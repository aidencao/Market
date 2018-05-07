package cn.market.pojo;

import java.util.Date;

public class DeliveryOrder {
    private String deliveryid;

    private String deliverystatus;

    private String sortername;

    private Integer sorterid;

    private Date sortingdatetime;

    private String couriername;

    private Integer courierid;

    private Date deliverydatetime;

    private String deliverycontent;

    public String getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(String deliveryid) {
        this.deliveryid = deliveryid == null ? null : deliveryid.trim();
    }

    public String getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliverystatus = deliverystatus == null ? null : deliverystatus.trim();
    }

    public String getSortername() {
        return sortername;
    }

    public void setSortername(String sortername) {
        this.sortername = sortername == null ? null : sortername.trim();
    }

    public Integer getSorterid() {
        return sorterid;
    }

    public void setSorterid(Integer sorterid) {
        this.sorterid = sorterid;
    }

    public Date getSortingdatetime() {
        return sortingdatetime;
    }

    public void setSortingdatetime(Date sortingdatetime) {
        this.sortingdatetime = sortingdatetime;
    }

    public String getCouriername() {
        return couriername;
    }

    public void setCouriername(String couriername) {
        this.couriername = couriername == null ? null : couriername.trim();
    }

    public Integer getCourierid() {
        return courierid;
    }

    public void setCourierid(Integer courierid) {
        this.courierid = courierid;
    }

    public Date getDeliverydatetime() {
        return deliverydatetime;
    }

    public void setDeliverydatetime(Date deliverydatetime) {
        this.deliverydatetime = deliverydatetime;
    }

    public String getDeliverycontent() {
        return deliverycontent;
    }

    public void setDeliverycontent(String deliverycontent) {
        this.deliverycontent = deliverycontent == null ? null : deliverycontent.trim();
    }
}