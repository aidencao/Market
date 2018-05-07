package cn.market.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.market.dao.ConfigMapper;
import cn.market.dao.CustomComplainMapper;
import cn.market.dao.CustomMapper;
import cn.market.dao.CustomOrderDetailMapper;
import cn.market.dao.CustomOrderMapper;
import cn.market.dao.GoodsTypeMapper;
import cn.market.dao.MachineInfoMapper;
import cn.market.dao.MachineLogMapper;
import cn.market.dao.RdSessionMapper;
import cn.market.pojo.BriefGoods;
import cn.market.pojo.Config;
import cn.market.pojo.Custom;
import cn.market.pojo.CustomComplain;
import cn.market.pojo.CustomOrder;
import cn.market.pojo.CustomOrderDetail;
import cn.market.pojo.CustomOrderDetailExample;
import cn.market.pojo.CustomOrderExample;
import cn.market.pojo.GoodsReturn;
import cn.market.pojo.GoodsType;
import cn.market.pojo.MachineInfo;
import cn.market.pojo.MachineLog;
import cn.market.pojo.RdSession;
import cn.market.pojo.RdSessionExample;
import cn.market.pojo.UserOrder;
import cn.market.pojo.UserorderDetail;
import cn.market.pojo.RdSessionExample.Criteria;
import cn.market.tools.DefinedChars;

@Service
public class WxappServiceImpl implements WxappService {

	@Autowired
	private ConfigMapper configMapper;

	@Autowired
	private CustomMapper customMapper;

	@Autowired
	private RdSessionMapper rdSessionMapper;

	@Autowired
	private CustomOrderMapper customOrderMapper;

	@Autowired
	private MachineInfoMapper machineInfoMapper;

	@Autowired
	private CustomOrderDetailMapper customOrderDetailMapper;

	@Autowired
	private CustomComplainMapper customComplainMapper;

	@Autowired
	private GoodsTypeMapper goodsTypeMapper;
	
	@Autowired
	private MachineLogMapper machineLogMapper;

	@Override
	public Config getWxappmalName() {

		/*
		 * OrderdetailExample orderdetailExample = new OrderdetailExample();
		 * cn.vendingmachine.pojo.OrderdetailExample.Criteria criteria =
		 * orderdetailExample.createCriteria();
		 * criteria.andOrderidEqualTo(orderid); List<Orderdetail> list =
		 * orderdetailMapper.selectByExample(orderdetailExample); return list;
		 */
		/*
		 * ConfigExample configExample = new ConfigExample(); Criteria
		 * createCriteria = configExample.createCriteria();
		 * createCriteria.andMalidEqualTo("1"); Config config = (Config)
		 * configMapper.selectByExample(configExample);
		 */
		Config config = configMapper.selectByPrimaryKey("201717");
		return config;
	}

	@Override
	public boolean hasCustomopenid(String openid) {
		// TODO Auto-generated method stub
		Custom custom = customMapper.selectByPrimaryKey(openid);
		if (custom == null)
			return false;
		return true;
	}

	@Override
	public void insertCustom(Custom custom) {
		// TODO Auto-generated method stub
		customMapper.insert(custom);
	}

	@Override
	public void updateCustom(Custom custom) {
		// TODO Auto-generated method stub
		customMapper.updateByPrimaryKey(custom);
	}

	@Override
	public boolean hasRdsession(String rdsession) {
		// TODO Auto-generated method stub
		RdSession session = rdSessionMapper.selectByPrimaryKey(rdsession);
		if (session == null)
			return false;
		return true;
	}

	@Override
	public void insertRdsession(RdSession rdsession) {
		// TODO Auto-generated method stub
		rdSessionMapper.insert(rdsession);
	}

	@Override
	public CustomOrder findCustomOrder(String orderid) {
		// TODO Auto-generated method stub
		CustomOrder order = customOrderMapper.selectByPrimaryKey(orderid);
		return order;
	}

	@Override
	public void updateRdsession(RdSession rdsession, String openid) {
		// TODO Auto-generated method stub
		/*
		 * OrderdetailExample orderdetailExample = new OrderdetailExample();
		 * cn.vendingmachine.pojo.OrderdetailExample.Criteria criteria =
		 * orderdetailExample.createCriteria();
		 * criteria.andOrderidEqualTo(orderid);
		 */
		RdSessionExample rdSessionExample = new RdSessionExample();
		Criteria criteria = rdSessionExample.createCriteria();
		criteria.andOpenidEqualTo(openid);
		rdSessionMapper.updateByExample(rdsession, rdSessionExample);
	}

	@Override
	public void login(RdSession rdsession, Custom custom, String openid,
			String sign, String signature) throws Exception {
		// TODO Auto-generated method stub
		if (!hasCustomopenid(openid)) {
			custom.setTotalcustomption(0.0);
			custom.setAccountbalance(0.0);
			insertCustom(custom);
			insertRdsession(rdsession);
		} else if (!sign.equals(signature)) {
			updateCustom(custom);
		}
		updateRdsession(rdsession, openid);
	}

	@Override
	public String findOpenid(String rdsession) throws Exception {
		// TODO Auto-generated method stub
		RdSession rdSession = rdSessionMapper.selectByPrimaryKey(rdsession);
		if (rdSession == null)
			throw new Exception("rdSession不存在,请验证输入");
		String openid = rdSession.getOpenid();
		return openid;
	}

	@Override
	public double findOrderprice(String orderid) throws Exception {
		// TODO Auto-generated method stub
		CustomOrder order = findCustomOrder(orderid);
		if (order == null)
			throw new Exception("用户订单号不存在,请验证输入");
		if (order.getOrderprice() == null || order.getOrderprice() == 0)
		/* throw new Exception("用户交易金额为0，无需付款"); */
		{
			order.setOrderprice(0.01);
			customOrderMapper.updateByPrimaryKey(order);
		}
		double orderprice = order.getOrderprice();
		return orderprice;
	}

	@Override
	public void handleCustomOrder(String orderid) throws Exception {
		// TODO Auto-generated method stub
		CustomOrder customOrder = findCustomOrder(orderid);
		if (customOrder == null)
			throw new Exception("订单号不存在");
		if (customOrder.getPaydatetime() != null
				&& customOrder.getPaystate() != 0) {
			System.out.println("订单已付款");
			return;
		}
		Date date = new Date();
		customOrder.setPaydatetime(date);
		customOrder.setPaystate(DefinedChars.PAID);
		customOrderMapper.updateByPrimaryKey(customOrder);
	}

	// 开柜操作
	@Override
	public CustomOrder open(String rdsession, String macid) throws Exception {
		String openid = findOpenid(rdsession);
		MachineInfo machineinfo = findMachineInfo(macid);
		if (machineinfo == null)
			throw new Exception("机器编号不存在");
		CustomOrder customorder = new CustomOrder();
		Custom custom = findCustom(openid);
		if (custom == null)
			throw new Exception("用户编号不存在");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderid = openid.substring(18) + "" + sdf.format(date);

		customorder.setOrderid(orderid);
		customorder.setMacid(macid);
		customorder.setCustomid(openid);
		customorder.setOpendatetime(date);
		customorder.setPaystate(DefinedChars.UNPAID);
		customorder.setOrderprice(0.0);
		insertCustomOrder(customorder);

		if (machineinfo.getMacdoorstatus() == null
				|| machineinfo.getMacdoorstatus() == null)
			throw new Exception("数据库未设置初值");

		if (machineinfo.getMacdoorstatus().equals("open"))
			throw new Exception("货柜已打开,请勿重复操作");

		if (!machineinfo.getMacrunningstatus().equals("等待"))
			throw new Exception("机器未处于等待状态,无法开柜");

		machineinfo.setMacdoorstatus("open");
		machineinfo.setCurcustomid(openid);
		machineinfo.setCurorderid(orderid);
		machineinfo.setMacrunningstatus("销售");
		updateMachineInfo(machineinfo);
		return customorder;
	}
	
	@Override
	public void handleOpenack(String macid) throws Exception {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = findMachineInfo(macid);
		MachineLog log = new MachineLog();
		String maclogid = createLog(macid);
		log.setDatetime(new Date());
		log.setErrortype("通信异常,确认超时");
		log.setMacid(macid);
		log.setMaclogid(maclogid);
		log.setTreatresult("UNTREATED");
		machineLogMapper.insert(log);
		machineInfo.setMacerror("通信异常");
		updateMachineInfo(machineInfo);
	}

	@Override
	public void restoreState(String rdsession, String macid) throws Exception {
		// TODO Auto-generated method stub
		MachineInfo machineinfo = findMachineInfo(macid);
		machineinfo.setMacdoorstatus("close");
		machineinfo.setMacrunningstatus("等待");
		updateMachineInfo(machineinfo);

		CustomOrder customOrder = findCustomOrder(machineinfo.getCurorderid());
		customOrder.setPaystate(DefinedChars.PAID);
		customOrder.setClosedatetime(new Date());
		customOrder.setPaydatetime(new Date());
		customOrderMapper.updateByPrimaryKey(customOrder);
	}

	@Override
	public MachineInfo findMachineInfo(String macid) {
		// TODO Auto-generated method stub
		MachineInfo machineInfo = machineInfoMapper.selectByPrimaryKey(macid);
		return machineInfo;
	}

	@Override
	public Custom findCustom(String openid) {
		// TODO Auto-generated method stub
		Custom custom = customMapper.selectByPrimaryKey(openid);
		return custom;
	}

	@Override
	public void insertCustomOrder(CustomOrder customorder) {
		// TODO Auto-generated method stub
		customOrderMapper.insert(customorder);
	}

	@Override
	public void updateMachineInfo(MachineInfo machineinfo) {
		// TODO Auto-generated method stub
		machineInfoMapper.updateByPrimaryKey(machineinfo);
	}

	@Override
	public List<GoodsReturn> findCustomOrderdetail(String orderid)
			throws Exception {
		// TODO Auto-generated method stub
		if (!hasOrderid(orderid))
			throw new Exception("订单号不存在,请验证输入");
		CustomOrderDetailExample orderdetailExample = new CustomOrderDetailExample();
		CustomOrderDetailExample.Criteria criteria = orderdetailExample
				.createCriteria();
		criteria.andOrderidEqualTo(orderid);
		List<CustomOrderDetail> list = customOrderDetailMapper
				.selectByExample(orderdetailExample);
		if (list.isEmpty())
			throw new Exception("当前订单无清单");
		List<GoodsReturn> goodslist = new ArrayList<GoodsReturn>();
		for (CustomOrderDetail detail : list) {
			String goodsname = findGoodsnameByid(detail.getGoodstypeid());
			String goodsspec = findGoodsspecByid(detail.getGoodstypeid());
			String goodsunit = findGoodsUnitByid(detail.getGoodstypeid());
			GoodsReturn goods = new GoodsReturn();
			goods.setCustomOrderDetail(detail);
			goods.setGoodsName(goodsname);
			goods.setGoodsSpec(goodsspec);
			goods.setGoodsUnit(goodsunit);
			goodslist.add(goods);
		}
		return goodslist;
	}

	@Override
	public void insertCustomComplain(CustomComplain complain) throws Exception {
		// TODO Auto-generated method stub
		customComplainMapper.insert(complain);
	}

	@Override
	public Map<String, Object> findUserInfo(String rdsession) throws Exception {
		// TODO Auto-generated method stub
		String openid = findOpenid(rdsession);
		Custom custom = customMapper.selectByPrimaryKey(openid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", custom.getName());
		map.put("phone", custom.getPhone());
		map.put("password", custom.getPassword());
		map.put("weixinId", custom.getWeixinid());
		map.put("totalCustomption", custom.getTotalcustomption());
		map.put("accountBalance", custom.getAccountbalance());
		map.put("nickname", custom.getNickname());
		map.put("gender", custom.getGender());
		map.put("language", custom.getLanguage());
		map.put("city", custom.getCity());
		map.put("province", custom.getProvince());
		map.put("cuntry", custom.getCountry());
		map.put("avatarurl", custom.getAvatarurl());
		return map;
	}

	@Override
	public boolean hasCustomComplainId(String customcomplainid)
			throws Exception {
		CustomComplain complain = customComplainMapper
				.selectByPrimaryKey(customcomplainid);
		if (complain == null)
			return false;
		else
			return true;
	}

	@Override
	public String findGoodsnameByid(int goodsid) {
		// TODO Auto-generated method stub
		GoodsType goods = goodsTypeMapper.selectByPrimaryKey(goodsid);
		String goodsname = goods.getGoodsname();
		return goodsname;
	}

	@Override
	public String findGoodsspecByid(int goodsid) {
		// TODO Auto-generated method stub
		GoodsType goods = goodsTypeMapper.selectByPrimaryKey(goodsid);
		String goodsspec = goods.getGoodsspec();
		return goodsspec;
	}

	@Override
	public String findGoodsUnitByid(int goodsid) {
		// TODO Auto-generated method stub
		GoodsType goods = goodsTypeMapper.selectByPrimaryKey(goodsid);
		String goodsUnit = goods.getGoodsunit();
		return goodsUnit;
	}

	@Override
	public String findGoodspicByid(int goodsid) {
		// TODO Auto-generated method stub
		GoodsType goods = goodsTypeMapper.selectByPrimaryKey(goodsid);
		String goodsPic = goods.getPic();
		return goodsPic;
	}

	@Override
	public String findSessionkeyByrdsession(String rdsession) {
		// TODO Auto-generated method stub
		RdSession session = rdSessionMapper.selectByPrimaryKey(rdsession);
		String key = session.getSessionkey();
		return key;
	}

	@Override
	public void bindMobile(String rdsession, String phonenumber)
			throws Exception {
		// TODO Auto-generated method stub
		String openid = findOpenid(rdsession);
		Custom custom = findCustom(openid);
		if (custom.getPhone() == null || custom.getPhone().equals(""))
			custom.setPhone(phonenumber);
		else
			throw new Exception("已绑定手机号,请勿重复操作");
		updateCustom(custom);
	}

	@Override
	public List<CustomOrder> findHistoricalCustomOrder(String rdsession)
			throws Exception {
		// TODO Auto-generated method stub
		String openid = findOpenid(rdsession);
		/*
		 * CustomOrderDetailExample orderdetailExample = new
		 * CustomOrderDetailExample(); CustomOrderDetailExample.Criteria
		 * criteria = orderdetailExample.createCriteria();
		 * criteria.andOrderidEqualTo(orderid);
		 */
		CustomOrderExample customOrderExample = new CustomOrderExample();
		cn.market.pojo.CustomOrderExample.Criteria criteria = customOrderExample
				.createCriteria();
		criteria.andCustomidEqualTo(openid);
		List<CustomOrder> list = customOrderMapper
				.selectByExample(customOrderExample);
		if (list.size() == 0)
			throw new Exception("当前用户无历史购买记录");
		return list;
	}

	@Override
	public double findCustomNopay(String rdsession) throws Exception {
		// TODO Auto-generated method stub
		List<CustomOrder> customOrderlist = findHistoricalCustomOrder(rdsession);
		double sum = 0.0;
		for (CustomOrder customOrder : customOrderlist) {
			if (customOrder.getPaystate() == DefinedChars.UNPAID)
				sum += customOrder.getOrderprice();
		}
		return sum;
	}

	@Override
	public double findCustomtotalcustomption(String rdsession) throws Exception {
		// TODO Auto-generated method stub
		String openid = findOpenid(rdsession);
		Custom custom = customMapper.selectByPrimaryKey(openid);
		double totalcustomption = custom.getTotalcustomption();
		return totalcustomption;
	}

	@Override
	public List<CustomOrder> findNopayCustomOrder(String rdsession)
			throws Exception {
		// TODO Auto-generated method stub
		List<CustomOrder> customOrderlist = findHistoricalCustomOrder(rdsession);
		List<CustomOrder> noPaylist = new ArrayList<CustomOrder>();
		for (CustomOrder customOrder : customOrderlist) {
			if (customOrder.getPaystate() == DefinedChars.UNPAID)
				noPaylist.add(customOrder);
		}
		if (noPaylist.size() != 0)
			return noPaylist;
		else
			return null;
	}

	// 返回规定格式的用户订单详情
	@Override
	public List<UserorderDetail> findHistoricalUserorderDetail(String rdsession)
			throws Exception {
		// TODO Auto-generated method stub
		List<CustomOrder> customOrderlist = findHistoricalCustomOrder(rdsession);
		List<UserorderDetail> userorderDetail = new ArrayList<UserorderDetail>();

		for (CustomOrder customOrder : customOrderlist) {

			UserorderDetail detail = new UserorderDetail();
			List<BriefGoods> briefGoodslist = new ArrayList<BriefGoods>();

			Date opendatetime = customOrder.getOpendatetime();
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String opendate = formatter.format(opendatetime);
			System.out.println(opendate);

			detail.setOrderDate(opendate);
			detail.setOrderId(customOrder.getOrderid());
			detail.setOrderPrice(customOrder.getOrderprice());
			detail.setPaystate(customOrder.getPaystate());

			CustomOrderDetailExample orderdetailExample = new CustomOrderDetailExample();
			CustomOrderDetailExample.Criteria criteria = orderdetailExample
					.createCriteria();
			criteria.andOrderidEqualTo(customOrder.getOrderid());
			List<CustomOrderDetail> list = customOrderDetailMapper
					.selectByExample(orderdetailExample);
			// 遍历所有的订单明细取出商品信息
			if (list != null) {
				for (CustomOrderDetail customOrderDetail : list) {
					BriefGoods briefGoods = new BriefGoods();
					briefGoods.setGoodssalePrice(customOrderDetail
							.getSaleprice());
					briefGoods.setGoodsName(findGoodsnameByid(customOrderDetail
							.getGoodstypeid()));
					briefGoods.setGoodsSpec(findGoodsspecByid(customOrderDetail
							.getGoodstypeid()));
					briefGoods.setGoodsPic(findGoodspicByid(customOrderDetail
							.getGoodstypeid()));
					briefGoodslist.add(briefGoods);
				}
				detail.setGoodsArr(briefGoodslist);
			} else
				detail.setGoodsArr(null);
			/*
			 * List<GoodsReturn> Orderdetail =
			 * findCustomOrderdetail(customOrder.getOrderid()); for (GoodsReturn
			 * goodsReturn : Orderdetail) { BriefGoods briefGoods = new
			 * BriefGoods();
			 * briefGoods.setGoodsName(goodsReturn.getGoodsName());
			 * briefGoods.setGoodsSpec(goodsReturn.getGoodsSpec());
			 * briefGoods.setGoodssalePrice
			 * (goodsReturn.getCustomOrderDetail().getSaleprice()); }
			 */
			userorderDetail.add(detail);
		}

		return userorderDetail;
	}

	@Override
	public boolean hasOrderid(String orderid) throws Exception {
		// TODO Auto-generated method stub
		if (orderid == null)
			throw new Exception("订单号未输入,请检查输入");
		CustomOrder customOrder = customOrderMapper.selectByPrimaryKey(orderid);
		if (customOrder == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean ismachineClose(String orderid) throws Exception {
		// TODO Auto-generated method stub
		CustomOrder customOrder = findCustomOrder(orderid);
		String macid = customOrder.getMacid();
		MachineInfo machineInfo = findMachineInfo(macid);
		String macdoorstatus = machineInfo.getMacdoorstatus();
		if (macdoorstatus.equals("open"))
			return false;
		else
			return true;
	}

	@Override
	public boolean ismachienHasClosetime(String orderid) throws Exception {
		// TODO Auto-generated method stub
		CustomOrder customOrder = findCustomOrder(orderid);
		Date date = customOrder.getClosedatetime();
		System.out.println("获取时间"+date);
		if(date == null)
			return false;
		else
			return true;
	}
	
	public String createLog(String macid) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String exceptiondate = formatter.format(date);
		String maclogid = exceptiondate + macid;
		return maclogid;
	}

	@Override
	public String findgoodsPic(int goodsType) {
		// TODO Auto-generated method stub
		GoodsType goods = goodsTypeMapper.selectByPrimaryKey(goodsType);
		String goodspic = goods.getPic();
		if(goodspic == null)
			return "";
		return goodspic;
	}

	@Override
	public boolean hasPhoneNumber(String rdSession) throws Exception{
		// TODO Auto-generated method stub
		String openid = findOpenid(rdSession);
		Custom custom = findCustom(openid);
		String phone = custom.getPhone();
		if(phone == null || phone.equals(""))
			return false;
		else
			return true;
	}
}