package cn.market.pojo;

public class DeliveryOrderDetail {
    private String deliveryid;

    private String macid;

    private Integer boxno;

    private Integer goodstypeid;

    private Integer num;

    public String getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(String deliveryid) {
        this.deliveryid = deliveryid == null ? null : deliveryid.trim();
    }

    public String getMacid() {
        return macid;
    }

    public void setMacid(String macid) {
        this.macid = macid == null ? null : macid.trim();
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}