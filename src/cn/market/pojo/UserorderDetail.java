package cn.market.pojo;

import java.util.List;

public class UserorderDetail {
	
	private String orderDate;
	
	private String orderId;
	
	private double orderPrice;
	
	private int paystate;
	
	private List<BriefGoods> goodsArr;
	
	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public List<BriefGoods> getGoodsArr() {
		return goodsArr;
	}

	public void setGoodsArr(List<BriefGoods> goodsArr) {
		this.goodsArr = goodsArr;
	}
	
}
