package cn.market.service;

import java.util.List;

import cn.market.pojo.Custom;
import cn.market.pojo.CustomOrder;
import cn.market.pojo.CustomOrderDetail;
import cn.market.pojo.DeliveryOrder;
import cn.market.pojo.GoodsType;
import cn.market.pojo.MachineBox;
import cn.market.pojo.MachineInfo;
import cn.market.pojo.SortingList;



public interface MachineService {
	
	//获取柜子的信息
	MachineInfo findMachineInfoByid(String id);
	
	//更新柜子信息
	void updateMachineInfoByid(MachineInfo machineinfo);
	
	//获取用户订单信息
	CustomOrder findOrderByorderid(String orderid);
	
	//获取订单列表
	List<CustomOrderDetail> findOrderlistByorderId(String orderid);
	
	//更新用户订单信息
	void updateOrderByorderId(CustomOrder customorder);
	
	//生成订单
	void insertCustomOrder(CustomOrder customorder);
	
	//生成订单明细
	void insertOrderdetail(CustomOrderDetail orderdetail);
	
	//获取boxinfo
	MachineBox findBoxinfo(String macid,int boxno);
	
	//更新boxinfo
	void updateBoxinfo(MachineBox machinebox); 
	
	//获取goodsinfo
	GoodsType findGoodsinfo(int goodstypeid);
	
	//获取某个柜子最后一条记录
	CustomOrder findlastorderBymacId(String macid);
	
	//获取Custom记录
	Custom findCustomByCustomId(String customid);
	
	//更新Custom表
	void updateCustominfo(Custom custom);
	
	//依据openid找到rdSession
	String findRdsessionByopenid(String openid);
	
	/*CustomOrder open(String customid, String macid) throws Exception;*/
	boolean buy(String macid, int boxno) throws Exception;
	boolean close(String macid) throws Exception;
	CustomOrder pay(String orderid) throws Exception;
	
	void insertMachine(MachineInfo machineInfo);
	
	//机器异常开关门处理
	void handleException(String macid, String state, String version);
	
	//机器掉线处理
	void handleDropped(String macid);
	
	//设置cur未空
	String updatecur(String macid);
	
	//处理上货逻辑
	void handleExhibit(String macid, String place, String state);
	
	//插入jason数据
	public void insertJson();
	
	//解析jason数据
	public SortingList analyzeJson(String deliveryid);
	
	//获取后门状态
	public String findBackdoorState(String macid);
	
	//获取前门状态
	public String findFrontdoorState(String macid);
	
	//由deliveryid获取全部deliveryorder字段
	public DeliveryOrder findDeliveryorder(String deliveryid);
	
	//初始化后门为open时的处理
	public void handleBackdoorOpen(String macid, String frontdoorstate);
	
	//初始化后门为close时的处理
	public void handleBackdoorClose(String macid, String frontdoorstate, String version);
	
	//处理电量低异常
	public void handleLowpower(String macid,int voltage);
	
	/*//测试用
	public void text(int goodsTypeid);*/
}
