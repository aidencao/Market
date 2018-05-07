package cn.market.pojo;

import java.util.Date;

public class CustomOrder {
    private String orderid;

    private String macid;

    private String customid;

    private Double orderprice;

    private Date opendatetime;

    private Date closedatetime;

    private Date paydatetime;

    private Integer paystate;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getMacid() {
        return macid;
    }

    public void setMacid(String macid) {
        this.macid = macid == null ? null : macid.trim();
    }

    public String getCustomid() {
        return customid;
    }

    public void setCustomid(String customid) {
        this.customid = customid == null ? null : customid.trim();
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    public Date getOpendatetime() {
        return opendatetime;
    }

    public void setOpendatetime(Date opendatetime) {
        this.opendatetime = opendatetime;
    }

    public Date getClosedatetime() {
        return closedatetime;
    }

    public void setClosedatetime(Date closedatetime) {
        this.closedatetime = closedatetime;
    }

    public Date getPaydatetime() {
        return paydatetime;
    }

    public void setPaydatetime(Date paydatetime) {
        this.paydatetime = paydatetime;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

	@Override
	public String toString() {
		return "CustomOrder [orderid=" + orderid + ", macid=" + macid
				+ ", customid=" + customid + ", orderprice=" + orderprice
				+ ", opendatetime=" + opendatetime + ", closedatetime="
				+ closedatetime + ", paydatetime=" + paydatetime
				+ ", paystate=" + paystate + "]";
	}
}