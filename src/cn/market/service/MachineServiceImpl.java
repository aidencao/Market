package cn.market.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
































import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.market.dao.CustomMapper;
import cn.market.dao.CustomOrderDetailMapper;
import cn.market.dao.CustomOrderMapper;
import cn.market.dao.DeliveryOrderDetailMapper;
import cn.market.dao.DeliveryOrderMapper;
import cn.market.dao.GoodsTypeMapper;
import cn.market.dao.MachineBoxMapper;
import cn.market.dao.MachineInfoMapper;
import cn.market.dao.MachineLogMapper;
import cn.market.dao.RdSessionMapper;
import cn.market.pojo.Custom;
import cn.market.pojo.CustomOrder;
import cn.market.pojo.CustomOrderDetail;
import cn.market.pojo.CustomOrderDetailExample;
import cn.market.pojo.CustomOrderExample;
import cn.market.pojo.DeliveryOrder;
import cn.market.pojo.DeliveryOrderDetail;
import cn.market.pojo.DeliveryOrderExample;
import cn.market.pojo.GoodsType;
import cn.market.pojo.MachineBox;
import cn.market.pojo.MachineBoxKey;
import cn.market.pojo.MachineInfo;
import cn.market.pojo.MachineLog;
import cn.market.pojo.RdSession;
import cn.market.pojo.RdSessionExample;
import cn.market.pojo.SortingItem;
import cn.market.pojo.SortingList;
import cn.market.pojo.CustomOrderExample.Criteria;
import cn.market.tools.DefinedChars;
import cn.market.tools.NumberUtil;
import cn.market.websocket.WebSocket;

@Service
public class MachineServiceImpl implements MachineService {

	@Autowired
	private MachineInfoMapper machineInfoMapper;

	@Autowired
	private CustomOrderMapper customOrderMapper;

	@Autowired
	private CustomOrderDetailMapper orderDetailMapper;

	@Autowired
	private MachineBoxMapper machineBoxMapper;

	@Autowired
	private GoodsTypeMapper goodsTypeMapper;

	@Autowired
	private CustomMapper customMapper;

	@Autowired
	private RdSessionMapper rdSessionMapper;

	@Autowired
	private MachineLogMapper machineLogMapper;
	
	@Autowired
	private DeliveryOrderMapper deliveryOrderMapper;
	
	@Autowired
	private DeliveryOrderDetailMapper deliveryOrderDetailMapper;

	@Override
	public MachineInfo findMachineInfoByid(String id) {
		MachineInfo machineinfo = machineInfoMapper.selectByPrimaryKey(id);
		return machineinfo;
	}

	@Override
	public void updateMachineInfoByid(MachineInfo machineinfo) {
		// TODO Auto-generated method stub
		machineInfoMapper.updateByPrimaryKey(machineinfo);
	}

	@Override
	public CustomOrder findOrderByorderid(String orderid) {
		// TODO Auto-generated method stub
		CustomOrder customer = customOrderMapper.selectByPrimaryKey(orderid);
		return customer;
	}

	@Override
	public List<CustomOrderDetail> findOrderlistByorderId(String orderid) {
		// TODO Auto-generated method stub
		CustomOrderDetailExample orderdetailExample = new CustomOrderDetailExample();
		CustomOrderDetailExample.Criteria criteria = orderdetailExample
				.createCriteria();
		criteria.andOrderidEqualTo(orderid);
		List<CustomOrderDetail> list = orderDetailMapper
				.selectByExample(orderdetailExample);
		return list;
	}

	@Override
	public void updateOrderByorderId(CustomOrder customorder) {
		// TODO Auto-generated method stub
		customOrderMapper.updateByPrimaryKey(customorder);

	}

	@Override
	public void insertCustomOrder(CustomOrder customorder) {
		// TODO Auto-generated method stub
		customOrderMapper.insert(customorder);
	}

	@Override
	public void insertOrderdetail(CustomOrderDetail orderdetail) {
		// TODO Auto-generated method stub
		orderDetailMapper.insert(orderdetail);
	}

	@Override
	public void updateBoxinfo(MachineBox machinebox) {
		// TODO Auto-generated method stub
		machineBoxMapper.updateByPrimaryKey(machinebox);
	}

	@Override
	public MachineBox findBoxinfo(String macid, int boxno) {
		// TODO Auto-generated method stub

		/*
		 * OrderdetailExample orderdetailExample = new OrderdetailExample();
		 * cn.vendingmachine.pojo.OrderdetailExample.Criteria criteria =
		 * orderdetailExample.createCriteria();
		 * criteria.andOrderidEqualTo(orderid);
		 */
		MachineBoxKey machineboxKey = new MachineBoxKey();
		machineboxKey.setBoxno(boxno);
		machineboxKey.setMacid(macid);
		MachineBox machinebox = machineBoxMapper
				.selectByPrimaryKey(machineboxKey);
		return machinebox;
	}

	@Override
	public GoodsType findGoodsinfo(int goodstypeid) {
		// TODO Auto-generated method stub
		GoodsType goodstype = goodsTypeMapper.selectByPrimaryKey(goodstypeid);
		return goodstype;
	}

	@Override
	public CustomOrder findlastorderBymacId(String macid) {
		// TODO Auto-generated method stub
		/* Date date = customOrderMapper.lastmacordertime(macid); */
		CustomOrderExample customorderExample = new CustomOrderExample();
		Criteria criteria = customorderExample.createCriteria();
		/* criteria.andOpendatetimeEqualTo(date); */
		List<CustomOrder> list = customOrderMapper
				.selectByExample(customorderExample);
		CustomOrder customorder = list.get(list.size() - 1);
		return customorder;
	}

	@Override
	public void updateCustominfo(Custom custom) {
		// TODO Auto-generated method stub
		customMapper.updateByPrimaryKey(custom);
	}

	@Override
	public Custom findCustomByCustomId(String customid) {
		// TODO Auto-generated method stub
		Custom custom = customMapper.selectByPrimaryKey(customid);
		return custom;
	}

	// 开柜操作
	/*
	 * @Override public CustomOrder open(String customid, String macid) throws
	 * Exception { MachineInfo machineinfo= findMachineInfoByid(macid);
	 * if(machineinfo == null) throw new Exception("机器编号不存在"); CustomOrder
	 * customorder = new CustomOrder(); Custom custom =
	 * findCustomByCustomId(customid); if(custom == null) throw new
	 * Exception("用户编号不存在"); Date date = new Date(); SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd-HH-mm-ss"); String orderid =
	 * customid+"::"+sdf.format(date);
	 * 
	 * customorder.setOrderid(orderid); customorder.setMacid(macid);
	 * customorder.setCustomid(customid); customorder.setOpendatetime(date);
	 * insertCustomOrder(customorder);
	 * 
	 * if(machineinfo.getMacdoorstatus().equals("open")) throw new
	 * Exception("货柜已打开,请勿重复操作");
	 * 
	 * machineinfo.setMacdoorstatus("open");
	 * machineinfo.setCurcustomid(customid); machineinfo.setCurorderid(orderid);
	 * machineinfo.setMacrunningstatus("销售");
	 * updateMachineInfoByid(machineinfo); return customorder; }
	 */

	// 获取商品操作
	@Override
	public boolean buy(String macid, int boxno) throws Exception {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if (machineInfo == null) {
			System.out.println("机器编号不存在");
			return false;
		}
		if (!machineInfo.getMacrunningstatus().equals("销售")) {
			System.out.println("机器未处于销售状态");
			return false;
		}
		MachineBox boxinfo = findBoxinfo(macid, boxno);
		if (boxinfo == null) {
			System.out.println("机器下盒子编号不存在");
			return false;
		}

		// 获取该机柜最后一条订单
		String orderid = machineInfo.getCurorderid();
		if (orderid == null || orderid == "") {
			System.out.println("用户订单号不存在");
			return false;
		}
		// 数量不对不做任何处理
		if (boxinfo.getGoodssum() - 1 < 0
				/*|| machineInfo.getCurrentsum() - 1 < 0*/) {
			System.out.println("商品已经取空");
			return false;
		}
		if(machineInfo.getCurrentsum()-1 >= 0)
			machineInfo.setCurrentsum(machineInfo.getCurrentsum() - 1);
		else
			machineInfo.setCurrentsum(0);
		updateMachineInfoByid(machineInfo);

		int goodstypeid = boxinfo.getGoodstypeid();
		GoodsType goodsinfo = findGoodsinfo(goodstypeid);
		boxinfo.setGoodssum(boxinfo.getGoodssum() - 1);
		boxinfo.setRateoutstock(boxinfo.getGoodssum()
				/ (double) boxinfo.getGoodsmaxsum());
		updateBoxinfo(boxinfo);

		CustomOrderDetail orderdetail = new CustomOrderDetail();
		orderdetail.setBoxno(boxno);
		orderdetail.setOrderid(orderid);
		orderdetail.setSalesum(1);
		orderdetail.setGoodstypeid(goodstypeid);
		orderdetail.setSaleprice(goodsinfo.getSaleprice());
		insertOrderdetail(orderdetail);

		String curcustomid = machineInfo.getCurcustomid();
		String rdsession = findRdsessionByopenid(curcustomid);
		// 要求访问/getOrderdetail
		WebSocket.sendMessage("take", rdsession);
		return true;
	}

	@Override
	public String findRdsessionByopenid(String openid) {
		RdSessionExample rdSessionExample = new RdSessionExample();
		cn.market.pojo.RdSessionExample.Criteria criteria = rdSessionExample
				.createCriteria();
		criteria.andOpenidEqualTo(openid);
		List<RdSession> list = rdSessionMapper
				.selectByExample(rdSessionExample);
		RdSession rdSession = list.get(list.size() - 1);
		String rdsession = rdSession.getRdsession();
		return rdsession;
	}

	// 关柜操作
	@Override
	public boolean close(String macid) throws Exception {
		MachineInfo machineinfo = findMachineInfoByid(macid);
		if (machineinfo == null) {
			System.out.println("机器编号不存在");
			return false;
		}
		if (machineinfo.getMacdoorstatus().equals("close")) {
			System.out.println("柜门已关闭，请勿重复操作");
		}

		double sum = 0.0;
		/* CustomOrder customorder = findlastorderBymacId(macId); */

		machineinfo.setMacdoorstatus("close");
		machineinfo.setMacrunningstatus("等待");
		/*
		 * machineinfo.setCurcustomid(null); machineinfo.setCurorderid(null);
		 */
		updateMachineInfoByid(machineinfo);

		String orderid = machineinfo.getCurorderid();
		if (orderid == null) {
			System.out.println("当前无订单号");
			return false;
		}
		CustomOrder customorder = findOrderByorderid(orderid);

		if (customorder == null) {
			System.out.println("未发现当前机器订单记录");
			return false;
		}
		List<CustomOrderDetail> list = findOrderlistByorderId(orderid);
		for (CustomOrderDetail orderdetail : list) {
			sum += orderdetail.getSaleprice();
		}

		customorder.setOrderprice(sum);
		customorder.setClosedatetime(new Date());
		// 如果没有买东西订单直接已支付
		if (sum == 0) {
			customorder.setPaystate(DefinedChars.PAID);
			customorder.setPaydatetime(new Date());
		}
		updateOrderByorderId(customorder);
		
		//这里保留两位小数
		sum = NumberUtil.formatDouble(sum);

		String customid = customorder.getCustomid();
		Custom custom = findCustomByCustomId(customid);
		//修改为两位小数
		double totalcustom = NumberUtil.formatDouble((custom.getTotalcustomption()+sum));
		custom.setTotalcustomption(totalcustom);
		updateCustominfo(custom);

		String rdsession = findRdsessionByopenid(customid);

		// 要求弹出支付对话框
		if (sum != 0)
			WebSocket.sendMessage("close", rdsession);
		else
			WebSocket.sendMessage("notake", rdsession);
		return true;
	}

	@Override
	public CustomOrder pay(String orderid) throws Exception {
		// TODO Auto-generated method stub
		CustomOrder customOrder = findOrderByorderid(orderid);
		if (customOrder == null)
			throw new Exception("订单号不存在");
		if (customOrder.getPaydatetime() != null)
			throw new Exception("订单已付款,无需重复支付");
		Date date = new Date();
		customOrder.setPaydatetime(date);
		updateOrderByorderId(customOrder);
		return customOrder;
	}

	@Override
	public void insertMachine(MachineInfo machineInfo) {
		// TODO Auto-generated method stub
		machineInfoMapper.insert(machineInfo);
	}
	
	//处理初始化
	@Override
	public void handleException(String macid, String state, String version) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if (machineInfo == null)
			System.out.println("机器编号不存在");
		if(machineInfo.getMacrunningstatus()!=null && machineInfo.getMacrunningstatus().equals("更新中"))
		machineInfo.setMacrunningstatus("等待");
		if(version != null)
		machineInfo.setVersion(Integer.parseInt(version));
		updateMachineInfoByid(machineInfo);
		
		String macdoorstatus = machineInfo.getMacdoorstatus();
		if (macdoorstatus.equals("open")) {
			if (!macdoorstatus.equals(state)) {
				MachineLog log = new MachineLog();
				String maclogid = createLog(macid);

				log.setDatetime(new Date());
				log.setErrortype("异常关门");
				log.setMacid(macid);
				log.setMaclogid(maclogid);
				log.setTreatresult("UNTREATED");
				machineLogMapper.insert(log);

				machineInfo.setMacerror("异常关门");
				machineInfo.setMacdoorstatus(state);
				machineInfo.setMacrunningstatus("等待");
				updateMachineInfoByid(machineInfo);
			}
		}

		if (macdoorstatus.equals("close")) {
			if (!macdoorstatus.equals(state)) {
				MachineLog log = new MachineLog();
				String maclogid = createLog(macid);

				log.setDatetime(new Date());
				log.setErrortype("异常开门");
				log.setMacid(macid);
				log.setMaclogid(maclogid);
				log.setTreatresult("UNTREATED");
				machineLogMapper.insert(log);

				machineInfo.setMacerror("异常开门");
				machineInfo.setMacdoorstatus(state);
				machineInfo.setMacrunningstatus("故障");
				machineInfo.setCurcustomid(null);
				machineInfo.setCurorderid(null);
				updateMachineInfoByid(machineInfo);
			}
		}

	}

	public String createLog(String macid) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String exceptiondate = formatter.format(date);
		String maclogid = exceptiondate + macid;
		return maclogid;
	}

	@Override
	public String updatecur(String macid) {
		// TODO Auto-generated method stub
		/*MachineInfo machineInfo = findMachineInfoByid(macid);
		machineInfo.setCurcustomid(null);
		machineInfo.setCurorderid(null);
		updateMachineInfoByid(machineInfo);*/
		DeliveryOrderExample deliveryOrderExample = new DeliveryOrderExample();
		cn.market.pojo.DeliveryOrderExample.Criteria criteria = deliveryOrderExample.createCriteria();
		criteria.andDeliveryidEqualTo("0");
		List<DeliveryOrder> list = deliveryOrderMapper.selectByExampleWithBLOBs(deliveryOrderExample);
		DeliveryOrder deliveryOrder = list.get(0);
		return deliveryOrder.getDeliverycontent();
	}

	@Override
	public void handleExhibit(String macid, String place, String state) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if(machineInfo == null)
		{
			System.out.println("机器编号不存在");
			return;
		}
		if(place.equals("back"))
		{
			if(state.equals("open"))
			{
				machineInfo.setBackdoorstatus("open");
				machineInfo.setMacrunningstatus("拣配");
				updateMachineInfoByid(machineInfo);	
			}
			
			if(state.equals("close"))
			{
				machineInfo.setBackdoorstatus("close");
				updateMachineInfoByid(machineInfo);
				
				String frontdoorState = findFrontdoorState(macid);
				if(frontdoorState != null && frontdoorState.equals("close"))
				{
					String deliveryid = machineInfo.getDeliveryid();
					DeliveryOrder deliveryorder = findDeliveryorder(deliveryid);
					String deliverystatus = deliveryorder.getDeliverystatus();
					machineInfo.setMacrunningstatus("等待");
					/*if(deliverystatus != null && deliverystatus.equals("已配货"))
					{
						machineInfo.setSortingstatus("上货完成");
					}*/
					updateMachineInfoByid(machineInfo);
				}
			}
			
		}
		
		else if(place.equals("front"))
		{
			if(state.equals("open"))
			{
				machineInfo.setMacdoorstatus("open");
				updateMachineInfoByid(machineInfo);
				
				String deliveryid = machineInfo.getDeliveryid();
				DeliveryOrder deliveryOrder = findDeliveryorder(deliveryid);
				SortingList sortinglist = analyzeJson(deliveryid);
				if(sortinglist == null)
					return;
				List<SortingItem> list = sortinglist.getList();
				String deliverystatus = deliveryOrder.getDeliverystatus();
				if(deliverystatus != null && deliverystatus.equals("配货中"))
				{
				int machineSumadd = 0;
				for(int i = 0; i<list.size(); i++)
				{
					DeliveryOrderDetail deliveryOrderDetail = new DeliveryOrderDetail();	
					Integer boxnum = list.get(i).getBoxnum();
					Integer goodsid = list.get(i).getGoodsid();
					String goodsname = list.get(i).getGoodsname();
					String goodsspec = list.get(i).getGoodsspec();
					String goodsunit = list.get(i).getGoodsunit();
					Integer num = list.get(i).getNum();
					
					deliveryOrderDetail.setBoxno(boxnum);
					deliveryOrderDetail.setDeliveryid(deliveryid);
					deliveryOrderDetail.setGoodstypeid(goodsid);
					deliveryOrderDetail.setMacid(macid);
					deliveryOrderDetail.setNum(num);
					deliveryOrderDetailMapper.insert(deliveryOrderDetail);
					
					MachineBox boxinfo = findBoxinfo(macid, boxnum);
					if(boxinfo.getGoodssum() == null)
						boxinfo.setGoodssum(0);
					if(boxinfo.getGoodstypeid() == goodsid)
					{
					boxinfo.setRateoutstock((boxinfo.getGoodssum()+num)/(double)(boxinfo.getGoodsmaxsum()));
					boxinfo.setGoodssum(boxinfo.getGoodssum()+num);
					/*boxinfo.setGoodstypeid(goodsid);*/
					/*machineSum += boxinfo.getGoodssum();*/
					machineSumadd += num;
					}
					else
					{
						boxinfo.setGoodssum(num);
						boxinfo.setGoodstypeid(goodsid);
						boxinfo.setRateoutstock(num/(double)(boxinfo.getGoodsmaxsum()));
						machineSumadd = machineSumadd + num - boxinfo.getGoodssum();
					}
					machineBoxMapper.updateByPrimaryKey(boxinfo);
				}
				deliveryOrder.setDeliverystatus("已配货");
				deliveryOrder.setDeliverydatetime(new Date());
				deliveryOrderMapper.updateByPrimaryKey(deliveryOrder);
				
				//双if换两句
				machineInfo.setSortingstatus("上货完成");
				if(machineInfo.getCurrentsum() == null)
					machineInfo.setCurrentsum(0);
				machineInfo.setCurrentsum(machineInfo.getCurrentsum()+machineSumadd);
				updateMachineInfoByid(machineInfo);
				
				}
				
			}
			
			if(state.equals("close"))
			{
				machineInfo.setMacdoorstatus("close");
				updateMachineInfoByid(machineInfo);
				
				String backdoorState = findBackdoorState(macid);
				if(backdoorState != null && backdoorState.equals("close") )
				{
					String deliveryid = machineInfo.getDeliveryid();
					DeliveryOrder deliveryorder = findDeliveryorder(deliveryid);
					String deliverystatus = deliveryorder.getDeliverystatus();
					machineInfo.setMacrunningstatus("等待");
					/*if(deliverystatus != null && deliverystatus.equals("已配货"))
					{
						machineInfo.setSortingstatus("上货完成");
					}*/
					updateMachineInfoByid(machineInfo);
				}
				
			}
		}
		
		
		}

	@Override
	public void insertJson() {
		// TODO Auto-generated method stub
		SortingList list = new SortingList(); 
		list.setMacid("000001");
		list.setSum(120);
		list.setNote(null);
		List<SortingItem>unitlist = new ArrayList<SortingItem>();
		for(int i = 1; i <12; i++)
		{
		SortingItem item = new SortingItem();
		item.setBoxnum(i);
		item.setGoodsid(1);
		item.setGoodsname("康师傅方便面220g");
		item.setGoodsspec("220g");
		item.setGoodsunit("桶");
		item.setNote("无");
		item.setNum(10);
		unitlist.add(item);
		}
		list.setList(unitlist);
		/*JSONArray jsonArray = JSONArray.fromObject(list);*/
		
		String json = JSON.toJSONString(list.getList());
		
		DeliveryOrder deliveryOrder = deliveryOrderMapper.selectByPrimaryKey("0");
		deliveryOrder.setDeliverycontent(json);
		DeliveryOrderExample deliveryOrderExample = new DeliveryOrderExample();
		cn.market.pojo.DeliveryOrderExample.Criteria criteria = deliveryOrderExample.createCriteria();
		criteria.andDeliveryidEqualTo("0");
		deliveryOrderMapper.updateByExampleWithBLOBs(deliveryOrder, deliveryOrderExample);
	}

	//解析delivery中的json字符串
	@Override
	public SortingList analyzeJson(String deliveryid) {
		// TODO Auto-generated method stub
		DeliveryOrderExample deliveryOrderExample = new DeliveryOrderExample();
		cn.market.pojo.DeliveryOrderExample.Criteria criteria = deliveryOrderExample.createCriteria();
		criteria.andDeliveryidEqualTo(deliveryid);
		List<DeliveryOrder> list = deliveryOrderMapper.selectByExampleWithBLOBs(deliveryOrderExample);
		DeliveryOrder deliveryOrder = list.get(0);
		String deliverycontent = deliveryOrder.getDeliverycontent();
		if(deliverycontent == null)
			return null;
		List<SortingItem> sort = JSON.parseArray(deliverycontent, SortingItem.class);
		SortingList sortinglist = new SortingList();
		sortinglist.setList(sort);
		/*SortingList sortinglist = JSON.parseObject(deliverycontent, SortingList.class);*/
		/*System.out.println(sortinglist.getMacid());
		System.out.println(sortinglist.getSum());*/
		for(int i = 0 ; i<sortinglist.getList().size();i++)
		{
			System.out.println(sortinglist.getList().get(i).toString());
		}
		return sortinglist;
	}

	@Override
	public String findBackdoorState(String macid) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if(machineInfo == null)
		{
			System.out.println("机器编号不存在");
			return null;
		}
		String backdoorstatus = machineInfo.getBackdoorstatus();
		return backdoorstatus;
	}

	@Override
	public String findFrontdoorState(String macid) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if(machineInfo == null)
		{
			System.out.println("机器编号不存在");
			return null;
		}
		String macdoorstatus = machineInfo.getMacdoorstatus();
		return macdoorstatus;
	}

	@Override
	public DeliveryOrder findDeliveryorder(String deliveryid) {
		// TODO Auto-generated method stub
		DeliveryOrderExample deliveryOrderExample = new DeliveryOrderExample();
		cn.market.pojo.DeliveryOrderExample.Criteria criteria = deliveryOrderExample.createCriteria();
		criteria.andDeliveryidEqualTo(deliveryid);
		List<DeliveryOrder> list = deliveryOrderMapper.selectByExampleWithBLOBs(deliveryOrderExample);
		if(list == null)
		{
			System.out.println("无配货清单");
			return null;
		}
		DeliveryOrder deliveryOrder = list.get(0);
		return deliveryOrder;
	}

	@Override
	public void handleBackdoorOpen(String macid, String frontdoorstate) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if(machineInfo == null)
		{
			System.out.println("机器编号不存在");
			return;
		}
		MachineLog log = new MachineLog();
		String maclogid = createLog(macid);

		log.setDatetime(new Date());
		log.setErrortype("上货异常,上货过程中重启");
		log.setMacid(macid);
		log.setMaclogid(maclogid);
		log.setTreatresult("UNTREATED");
		machineLogMapper.insert(log);
		
		//数据库中的状态
		String backdoorState = findBackdoorState(macid);
		String findFrontdoorState = findFrontdoorState(macid);
		
		if(backdoorState.equals("open"))
		{
			if(frontdoorstate.equals(findFrontdoorState))
				return;
			else if(frontdoorstate.equals("open"))
			{
				handleExhibit(macid, "front", "open");
			}
			else if(frontdoorstate.equals("close"))
			{
				/*machineInfo.setMacdoorstatus("close");
				updateMachineInfoByid(machineInfo);*/
				handleExhibit(macid, "front", "close");
			}
		}
		else if(backdoorState.equals("close"))
		{
			handleExhibit(macid, "back", "open");
			if(frontdoorstate.equals("open") && findFrontdoorState.equals("close"))
			{
				handleExhibit(macid, "front", "open");
			}
			if(frontdoorstate.equals("close") && findFrontdoorState.equals("open"))
			{
				handleExhibit(macid, "front", "close");
			}
		}
	}

	@Override
	public void handleBackdoorClose(String macid, String frontdoorstate, String version) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if(machineInfo == null)
		{
			System.out.println("机器编号不存在");
			return;
		}
		MachineLog log = new MachineLog();
		String maclogid = createLog(macid);

		log.setDatetime(new Date());
		log.setErrortype("上货异常,上货过程中重启");
		log.setMacid(macid);
		log.setMaclogid(maclogid);
		log.setTreatresult("UNTREATED");
		
		
		//数据库中的状态
		String backdoorState = findBackdoorState(macid);
		String findFrontdoorState = findFrontdoorState(macid);
		if(backdoorState.equals("open"))
		{
			machineLogMapper.insert(log);
			if(findFrontdoorState.equals("open") && frontdoorstate.equals("open"))
			{
				handleExhibit(macid, "back", "close");
			}
			else if(frontdoorstate.equals("open") && findFrontdoorState.equals("close"))
			{
				handleExhibit(macid, "front", "open");
				handleExhibit(macid, "back", "close");
			}
			else if(frontdoorstate.equals("close") && findFrontdoorState.equals("open"))
			{
				handleExhibit(macid, "front", "close");
				handleExhibit(macid, "back", "close");
			}
			else if(frontdoorstate.equals("close") && findFrontdoorState.equals("close"))
			{
				handleExhibit(macid, "back", "close");
			}
		}
		else if(backdoorState.equals("close"))
		{
			String macrunningstatus = machineInfo.getMacrunningstatus();
			if(macrunningstatus.equals("拣配"))
			{
				machineLogMapper.insert(log);
				if(frontdoorstate.equals("close") && findFrontdoorState.equals("open"))
				{
					handleExhibit(macid, "front", "close");
				}
			}
			else
			{
				handleException(macid, frontdoorstate, version);
			}
		}
		
	}

	@Override
	public void handleLowpower(String macid, int voltage) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if(machineInfo == null)
		{
			System.out.println("机器编号不存在");
			return;
		}
		MachineLog log = new MachineLog();
		String maclogid = createLog(macid);

		log.setDatetime(new Date());
		log.setErrortype("电量低,"+voltage+"mV");
		log.setMacid(macid);
		log.setMaclogid(maclogid);
		log.setTreatresult("UNTREATED");
		
		machineInfo.setMacerror("电量低");
		machineInfo.setBatteryvoltage(voltage);
		
		machineLogMapper.insert(log);
		updateMachineInfoByid(machineInfo);
	}

	@Override
	public void handleDropped(String macid) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfoByid(macid);
		if (machineInfo == null)
		{
			System.out.println("机器编号不存在");
			return;
		}
		MachineLog log = new MachineLog();
		String maclogid = createLog(macid);

		log.setDatetime(new Date());
		log.setErrortype("售货机掉线");
		log.setMacid(macid);
		log.setMaclogid(maclogid);
		log.setTreatresult("UNTREATED");
		
		machineInfo.setMacerror("掉线");
		
		machineLogMapper.insert(log);
		updateMachineInfoByid(machineInfo);
		
	}

	/*@Override
	public void text(int goodsTypeid) {
		// TODO Auto-generated method stub
		GoodsType goods = goodsTypeMapper.selectByPrimaryKey(goodsTypeid);
		goods.setSaleprice(0.06);
		goodsTypeMapper.updateByPrimaryKey(goods);
	}
*/
	/*
	 * ItemsExample itemsExample = new ItemsExample(); ItemsExample.Criteria
	 * criteria = itemsExample.createCriteria();
	 */

}
