package cn.market.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.market.pojo.BriefGoods;
import cn.market.pojo.CustomOrder;
import cn.market.pojo.GoodsUnit;
import cn.market.pojo.Returndata;
import cn.market.pojo.UserorderDetail;
import cn.market.service.WxappService;
import cn.market.tools.AesCbcUtil;
import cn.market.tools.DefinedChars;
import cn.market.tools.MonthDays;
import cn.market.tools.NumberUtil;

@Controller
@RequestMapping("/wxapp")
public class getUserInfoController {

	@Resource
	private WxappService wxappService;

	public static Logger logger = Logger.getLogger(getUserInfoController.class);

	@RequestMapping("/getUserInfo")
	@ResponseBody
	public Map<String, Object> getUserInfo(HttpServletRequest request)
			throws Exception {
		String rdsession = request.getParameter("rdSession");
		if(rdsession == null)
			throw new Exception("rdSession未输入");
		Map<String, Object> map = wxappService.findUserInfo(rdsession);
		return map;
	}

	@RequestMapping("/bindMobile")
	@ResponseBody
	public Returndata getPhoneNumber(HttpServletRequest request)
			throws Exception {
		String encrypteddata = request.getParameter("encryptedData");
		String iv = request.getParameter("iv");
		String rdsession = request.getParameter("rdSession");
		
		if(encrypteddata == null || iv == null || rdsession == null)
			throw new Exception("enctyptedData或iv或rdSession未输入");
		
		String WebAccessToken = wxappService
				.findSessionkeyByrdsession(rdsession);
		System.out.println(WebAccessToken);
		System.out.println(encrypteddata);
		System.out.println(iv);
		iv = iv.replace(" ", "+");
		String result;
		encrypteddata = encrypteddata.replace(" ", "+");
		
		System.out.println(WebAccessToken);
		System.out.println(encrypteddata);
		System.out.println(iv);
		
		try {
			result = AesCbcUtil.decrypt(encrypteddata, WebAccessToken, iv,
					"UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			throw new Exception("绑定手机号失败,请检查登录状态和手机号是否与微信绑定");
		}
		JSONObject userInfoJSON = JSONObject.parseObject(result);
		System.out.println("解析后的数据为:" + userInfoJSON);
		String phonenumber = userInfoJSON.getString("phoneNumber");
		wxappService.bindMobile(rdsession, phonenumber);
		Map<String, String> map = new HashMap<String, String>();
		map.put("state", "绑定成功");
		Returndata data = new Returndata(DefinedChars.SUCCESSCODE, map,
				"SUCCESS");
		return data;
	}


	@RequestMapping("/getCustomOrder")
	@ResponseBody
	public Returndata getCustomOrder(HttpServletRequest request)
			throws Exception {
		String rdsession = request.getParameter("rdSession");
		String status = request.getParameter("status");
		if(rdsession == null || status == null)
			throw new Exception("rdSession或status未输入");
		if (!status.equals("0") && !status.equals("1") && !status.equals("2"))
			throw new Exception("status输入有误请检查输入");
		List<CustomOrder> customOrderlist = wxappService
				.findHistoricalCustomOrder(rdsession);
		List<CustomOrder> NopayOrder = new ArrayList<CustomOrder>();
		List<CustomOrder> payOrder = new ArrayList<CustomOrder>();
		for (CustomOrder customOrder : customOrderlist) {
			if (customOrder.getPaystate() == DefinedChars.UNPAID)
				NopayOrder.add(customOrder);
			else
				payOrder.add(customOrder);
		}
		Returndata returndata = null;
		if (status.equals("0")) {
			returndata = new Returndata(DefinedChars.SUCCESSCODE, NopayOrder,
					"SUCCESS");
		} else if (status.equals("1")) {
			returndata = new Returndata(DefinedChars.SUCCESSCODE, payOrder,
					"SUCCESS");
		} else if (status.equals("2")) {
			returndata = new Returndata(DefinedChars.SUCCESSCODE,
					customOrderlist, "SUCCESS");
		}

		return returndata;
	}

	@RequestMapping("/getUserorderHistory")
	@ResponseBody
	public Returndata getUserorderHistory(HttpServletRequest request)
			throws Exception {
		String rdsession = request.getParameter("rdSession");
		String status = request.getParameter("status");
		if(status == null || rdsession == null)
			throw new Exception("status或rdSession未输入");
		if (!status.equals("0") && !status.equals("1") && !status.equals("2"))
			throw new Exception("status输入有误请检查输入");
		List<UserorderDetail> userorderDetaillist = wxappService
				.findHistoricalUserorderDetail(rdsession);
		
		Iterator<UserorderDetail> it = userorderDetaillist.iterator();
		while(it.hasNext())
		{
			UserorderDetail userorderDetail = it.next();
			if(userorderDetail.getOrderPrice() == 0)
				it.remove();
		}
		
		List<UserorderDetail> nopayorderDetaillist = new ArrayList<UserorderDetail>();
		List<UserorderDetail> payorderDetaillist = new ArrayList<UserorderDetail>();
		for (UserorderDetail userorderDetail : userorderDetaillist) {
			if (userorderDetail.getPaystate() == DefinedChars.UNPAID)
				nopayorderDetaillist.add(userorderDetail);
			else
				payorderDetaillist.add(userorderDetail);
		}
		/* logger.debug("this test info"); */
		Map<String, List<UserorderDetail>> map = new HashMap<String, List<UserorderDetail>>();
		if (status.equals("2"))
			map.put("orderList", userorderDetaillist);
		else if (status.equals("0"))
			map.put("orderList", nopayorderDetaillist);
		else if (status.equals("1"))
			map.put("orderList", payorderDetaillist);
		
		List<UserorderDetail> list = map.get("orderList");
		List<UserorderDetail> subList = new ArrayList<UserorderDetail>();
	
		if(list.size() > 10)
		{
			for(int i = list.size() - 1; i > list.size() - 11; i--)
				subList.add(list.get(i));
			map.put("orderList", subList);
		}
		else{
			Collections.reverse(list);
		}
		
		/*Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = dateFormat.format(date);
		System.out.println(nowDate);
		String[] split = nowDate.split("-");
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);
		int days = MonthDays.getDays(year,month, day);
		
		Iterator<UserorderDetail> iter = list.iterator();
		while(iter.hasNext())
		{	
			UserorderDetail next = iter.next();
			String orderDate = next.getOrderDate();
			orderDate = orderDate.substring(0,10);
			String[] dateSplit = orderDate.split("-");
			int historyDays = MonthDays.getDays(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]),Integer.parseInt(dateSplit[2]));
			System.out.println(historyDays);
			if((days - historyDays) > 30)
				iter.remove();
		}*/
		
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE, map,
				"SUCCESS");
		return returndata;
	}

	
	@RequestMapping("/getTotalcustomption")
	@ResponseBody
	public Returndata getTotalcustomption(HttpServletRequest request)
			throws Exception {
		String rdsession = request.getParameter("rdSession");
		if(rdsession == null)
			throw new Exception("rdSession未输入");
		double customtotalcustomption = wxappService
				.findCustomtotalcustomption(rdsession);
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("totalcustomption", customtotalcustomption);
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE, map,
				"SUCCESS");
		return returndata;
	}

	@RequestMapping("/userDetail")
	@ResponseBody
	public Returndata getuserDetail(HttpServletRequest request)
			throws Exception {
		String rdsession = request.getParameter("rdSession");
		if(rdsession == null)
			throw new Exception("rdSession未输入");
		Map<String, Object> userInfo = wxappService.findUserInfo(rdsession);
		Map<String, Object> userDetail = new HashMap<String, Object>();
		userDetail.put("phone", userInfo.get("phone"));
		userDetail.put("nickname", userInfo.get("nickname"));
		userDetail.put("city", userInfo.get("city"));
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE,
				userDetail, "SUCCESS");
		return returndata;
	}
	
	public List<BriefGoods> getUniqueorder(UserorderDetail detail)
	{
		List<BriefGoods> goodsArr = detail.getGoodsArr();
		
		Map<String,Integer>map = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < goodsArr.size(); i++)
		{
			Integer put = map.put(goodsArr.get(i).getGoodsName(),1);
			if(put!=null)
			{
				map.put(goodsArr.get(i).getGoodsName(), ++put);
			}
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) { 
			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
			}
		System.out.println("调用完成");
		
		List<BriefGoods> goodslist = new ArrayList<BriefGoods>();
		for (Entry<String, Integer> entry : map.entrySet()) { 
			BriefGoods goods = new BriefGoods();
			goods.setGoodsName(entry.getKey());
			for(int i = 0 ; i < goodsArr.size(); i++)
			{
				if(goodsArr.get(i).getGoodsName().equals(entry.getKey()))
				{	
					goods.setGoodsPic(goodsArr.get(i).getGoodsPic());
					goods.setGoodssalePrice(goodsArr.get(i).getGoodssalePrice());
					goods.setGoodsSpec(goodsArr.get(i).getGoodsSpec());
					/*goods.setSum(entry.getValue());*/
				}
			}
			goodslist.add(goods);
			}
		return goodslist;
		
	}
}
