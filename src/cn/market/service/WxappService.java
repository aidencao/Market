package cn.market.service;

import java.util.List;
import java.util.Map;

import cn.market.pojo.Config;
import cn.market.pojo.Custom;
import cn.market.pojo.CustomComplain;
import cn.market.pojo.CustomOrder;
import cn.market.pojo.CustomOrderDetail;
import cn.market.pojo.GoodsReturn;
import cn.market.pojo.MachineInfo;
import cn.market.pojo.RdSession;
import cn.market.pojo.UserorderDetail;

public interface WxappService {

	// 获取微信小程序名称
	public Config getWxappmalName();

	// 查看openid
	public boolean hasCustomopenid(String openid);

	// 插入用户
	public void insertCustom(Custom custom);

	// 更新用户
	public void updateCustom(Custom custom);

	// 查找rdsession是否存在
	public boolean hasRdsession(String rdsession);

	// 插入rd_session表
	public void insertRdsession(RdSession rdsession);

	// 更新rd_session表
	public void updateRdsession(RdSession rdsession, String openid);

	// 依据macId查找mac
	MachineInfo findMachineInfo(String macid);

	// 依据openId查找用户记录
	Custom findCustom(String openid);

	// 依据orderid查找订单记录
	public CustomOrder findCustomOrder(String orderid);
	
	//插入商户订单记录
	public void insertCustomOrder(CustomOrder customorder);
	
	//获取订单详细记录
	public List<GoodsReturn> findCustomOrderdetail(String orderid) throws Exception;
	
	//更新货柜信息
	public void updateMachineInfo(MachineInfo machineinfo);
	
	// 登录操作
	public void login(RdSession rdSession, Custom custom, String openid,
			String sign, String signature) throws Exception;

	// 依据rdsession查找openid
	public String findOpenid(String rdsession) throws Exception;

	// 依据orderId查找orderprice
	public double findOrderprice(String orderid) throws Exception;

	// 付款之后接收微信服务器消息更新用户订单
	public void handleCustomOrder(String orderid) throws Exception;

	//点击开柜按钮进行开柜
	CustomOrder open(String rdsession, String macid) throws Exception;
	
	//插入用户投诉信息
	void insertCustomComplain(CustomComplain complain) throws Exception;
	
	//依据rdsession获取用户信息
	public Map<String,Object> findUserInfo(String rdsession) throws Exception;
	
	//检查customComplain是否存在
	public boolean hasCustomComplainId(String customcomplainid) throws Exception;
	
	//依据商品id找到商品名称
	public String findGoodsnameByid(int goodsid);
	
	//获取商品规格
	public String findGoodsspecByid(int goodsid);
	
	//获取商品单位
	public String findGoodsUnitByid(int goodsid);
	
	//获取商品图片
	public String findGoodspicByid(int goodsid);
	
	//依据rdsession获取sessionkey
	public String findSessionkeyByrdsession(String rdsession);
	
	//绑定手机号
	public void bindMobile(String rdsession, String phonenumber) throws Exception;
	
	//获取用户的历史订单记录
	public List<CustomOrder> findHistoricalCustomOrder(String rdsession) throws Exception; 
	
	//获取用户未结算金额
	public double findCustomNopay(String rdsession) throws Exception;
	
	//获取用户的消费金额
	public double findCustomtotalcustomption(String rdsession) throws Exception;
	
	//获取未付钱的订单号
	public List<CustomOrder> findNopayCustomOrder(String rdsession) throws Exception;
	
	//依照格式获取用户订单信息及其商品详情
	public List<UserorderDetail> findHistoricalUserorderDetail(String rdsession) throws Exception;
	
	//判断用户订单号标号是否存在
	public boolean hasOrderid(String orderid) throws Exception;
	
	//开柜消息发送失败的还原操作
	public void restoreState(String rdsession, String macid) throws Exception;
	
	//依据订单查询查询货柜状态是否是关闭
	public boolean ismachineClose(String orderid) throws Exception;
	
	//依据订单是否关柜来判断是否要进行支付流程
	public boolean ismachienHasClosetime(String orderid) throws Exception;
	
	//开柜调用接口
	public void handleOpenack(String macid) throws Exception;
	
	//获取商品图片
	public String findgoodsPic(int goodsType);
	
	//判断是否绑定了手机号
	public boolean hasPhoneNumber(String rdSession) throws Exception;
}
