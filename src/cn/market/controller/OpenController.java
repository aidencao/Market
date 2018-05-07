package cn.market.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.market.mqtt.MarketMqttClient;
import cn.market.pojo.Config;
import cn.market.pojo.CustomOrder;
import cn.market.pojo.Globalack;
import cn.market.pojo.Returndata;
import cn.market.service.MachineService;
import cn.market.service.WxappService;
import cn.market.tools.DefinedChars;

@Controller
@RequestMapping("/wxapp")
public class OpenController {
	/*
	 * @Resource private MachineService machineService;
	 * 
	 * @RequestMapping("/getByid")
	 * 
	 * @ResponseBody public Machineinfo getByid(HttpServletRequest
	 * request)throws Exception{ String id = request.getParameter("id");
	 * Machineinfo machineinfo = machineService.findByid(id); return
	 * machineinfo; }
	 */
	@Resource
	private WxappService wxappService;

	// 用户开门:1.更新machineinfo的状态 2.调用发送数据的方法 3.插入用户订单并返回用户订单号
	@RequestMapping("/cheak")
	@ResponseBody
	public Returndata Cheak(HttpServletRequest request) throws Exception {
		String rdSession = request.getParameter("rdSession");
		String macid = request.getParameter("macId");
		if (rdSession == null || macid == null)
			throw new Exception("未输入机器号或用户编号");
		if(!wxappService.hasPhoneNumber(rdSession))
		{
			Returndata phoneData = new Returndata("599", "您未绑定手机号,请先绑定", "Error");
			return phoneData;
		}
		CustomOrder customOrder = wxappService.open(rdSession, macid);
		if (MarketMqttClient.send("open/" + macid, "open")) {
			boolean ackflag = false;
			long begintime = System.currentTimeMillis();
			while (System.currentTimeMillis() - begintime < 15000) {
				if (Globalack.ackmap.get(macid) != null
						&& (System.currentTimeMillis() - Globalack.ackmap
								.get(macid)) < 15000
						&& (System.currentTimeMillis() - Globalack.ackmap
								.get(macid)) > 0) {
					ackflag = true;
					break;
				}
			}
			Iterator<Entry<String, Long>> iterator = Globalack.ackmap
					.entrySet().iterator();
			for (Entry<String, Long> entry : Globalack.ackmap.entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = "
						+ entry.getValue());
			}

			if (ackflag) {
				Globalack.ackmap.remove(macid);
				Map<String, String> orderid = new HashMap<String, String>();
				orderid.put("orderid", customOrder.getOrderid());
				Returndata returndata = new Returndata(
						DefinedChars.SUCCESSCODE, orderid, "SUCCESS");
				return returndata;
			}
			/*
			 * while(iterator.hasNext()) { Entry<String, Long> entry =
			 * iterator.next(); if(entry.getKey().equals(macid)) {
			 * System.out.println("ACK消息已记录");
			 * if((System.currentTimeMillis()-entry.getValue())<10000) ackflag =
			 * true; iterator.remove(); } }
			 */
			else {
				System.out.println("已超时");
				wxappService.restoreState(rdSession, macid);
				wxappService.handleOpenack(macid);
				throw new Exception("货箱确认超时,请重新扫码");
			}

		} else {
			wxappService.restoreState(rdSession, macid);
			throw new Exception("网络质量差,发送开柜消息失败，请重试");
		}
	}
	
	@RequestMapping("/openDoor")
	@ResponseBody
	public Returndata openDoor(HttpServletRequest request) throws Exception{
		String rdSession = request.getParameter("rdSession");
		String macid = request.getParameter("macId");
		if (rdSession == null || macid == null)
			throw new Exception("未输入机器号或用户编号");
		if (MarketMqttClient.send("open/" + macid, "open")) {
			
		}
		else {
			throw new Exception("网络质量差,发送开门消息失败，请重试");
		}
		Returndata returndata = new Returndata(
				DefinedChars.SUCCESSCODE, "开门消息已发送", "SUCCESS");
		return returndata;
	}
}
