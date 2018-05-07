package cn.market.pojo;

public class CustomComplain {
    private String customcomplainid;

    private String customid;

    private String complaininfo;

    private String complaintreat;

    private Integer treat;

    private Integer managerid;

    public String getCustomcomplainid() {
        return customcomplainid;
    }

    public void setCustomcomplainid(String customcomplainid) {
        this.customcomplainid = customcomplainid == null ? null : customcomplainid.trim();
    }

    public String getCustomid() {
        return customid;
    }

    public void setCustomid(String customid) {
        this.customid = customid == null ? null : customid.trim();
    }

    public String getComplaininfo() {
        return complaininfo;
    }

    public void setComplaininfo(String complaininfo) {
        this.complaininfo = complaininfo == null ? null : complaininfo.trim();
    }

    public String getComplaintreat() {
        return complaintreat;
    }

    public void setComplaintreat(String complaintreat) {
        this.complaintreat = complaintreat == null ? null : complaintreat.trim();
    }

    public Integer getTreat() {
        return treat;
    }

    public void setTreat(Integer treat) {
        this.treat = treat;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }
}