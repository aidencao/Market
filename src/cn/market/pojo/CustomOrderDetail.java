package cn.market.pojo;

public class CustomOrderDetail {
    private String orderid;

    private Integer boxno;

    private Integer goodstypeid;

    private Integer salesum;

    private Double saleprice;

    private Integer userid;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getBoxno() {
        return boxno;
    }

    public void setBoxno(Integer boxno) {
        this.boxno = boxno;
    }

    public Integer getGoodstypeid() {
        return goodstypeid;
    }

    public void setGoodstypeid(Integer goodstypeid) {
        this.goodstypeid = goodstypeid;
    }

    public Integer getSalesum() {
        return salesum;
    }

    public void setSalesum(Integer salesum) {
        this.salesum = salesum;
    }

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}