package cn.market.pojo;

public class MachineInfo {
    private String macid;

    private Integer mactype;

    private String maclocation;

    private String warehouseid;

    private Integer totalsum;

    private Integer currentsum;

    private String sortingstatus;

    private String deliveryid;

    private String backdoorstatus;

    private String macdoorstatus;

    private String macrunningstatus;

    private String macerror;

    private String twodimencode;

    private Integer batteryvoltage;

    private String curcustomid;

    private String curorderid;

    private Integer managerid;

    private Integer userid;

    private String managername;

    private Integer version;

    public String getMacid() {
        return macid;
    }

    public void setMacid(String macid) {
        this.macid = macid == null ? null : macid.trim();
    }

    public Integer getMactype() {
        return mactype;
    }

    public void setMactype(Integer mactype) {
        this.mactype = mactype;
    }

    public String getMaclocation() {
        return maclocation;
    }

    public void setMaclocation(String maclocation) {
        this.maclocation = maclocation == null ? null : maclocation.trim();
    }

    public String getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(String warehouseid) {
        this.warehouseid = warehouseid == null ? null : warehouseid.trim();
    }

    public Integer getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(Integer totalsum) {
        this.totalsum = totalsum;
    }

    public Integer getCurrentsum() {
        return currentsum;
    }

    public void setCurrentsum(Integer currentsum) {
        this.currentsum = currentsum;
    }

    public String getSortingstatus() {
        return sortingstatus;
    }

    public void setSortingstatus(String sortingstatus) {
        this.sortingstatus = sortingstatus == null ? null : sortingstatus.trim();
    }

    public String getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(String deliveryid) {
        this.deliveryid = deliveryid == null ? null : deliveryid.trim();
    }

    public String getBackdoorstatus() {
        return backdoorstatus;
    }

    public void setBackdoorstatus(String backdoorstatus) {
        this.backdoorstatus = backdoorstatus == null ? null : backdoorstatus.trim();
    }

    public String getMacdoorstatus() {
        return macdoorstatus;
    }

    public void setMacdoorstatus(String macdoorstatus) {
        this.macdoorstatus = macdoorstatus == null ? null : macdoorstatus.trim();
    }

    public String getMacrunningstatus() {
        return macrunningstatus;
    }

    public void setMacrunningstatus(String macrunningstatus) {
        this.macrunningstatus = macrunningstatus == null ? null : macrunningstatus.trim();
    }

    public String getMacerror() {
        return macerror;
    }

    public void setMacerror(String macerror) {
        this.macerror = macerror == null ? null : macerror.trim();
    }

    public String getTwodimencode() {
        return twodimencode;
    }

    public void setTwodimencode(String twodimencode) {
        this.twodimencode = twodimencode == null ? null : twodimencode.trim();
    }

    public Integer getBatteryvoltage() {
        return batteryvoltage;
    }

    public void setBatteryvoltage(Integer batteryvoltage) {
        this.batteryvoltage = batteryvoltage;
    }

    public String getCurcustomid() {
        return curcustomid;
    }

    public void setCurcustomid(String curcustomid) {
        this.curcustomid = curcustomid == null ? null : curcustomid.trim();
    }

    public String getCurorderid() {
        return curorderid;
    }

    public void setCurorderid(String curorderid) {
        this.curorderid = curorderid == null ? null : curorderid.trim();
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername == null ? null : managername.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}