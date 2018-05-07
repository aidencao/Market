package cn.market.pojo;

import java.util.Date;

public class MachineLog {
    private String maclogid;

    private String macid;

    private Date datetime;

    private String errortype;

    private String treatresult;

    public String getMaclogid() {
        return maclogid;
    }

    public void setMaclogid(String maclogid) {
        this.maclogid = maclogid == null ? null : maclogid.trim();
    }

    public String getMacid() {
        return macid;
    }

    public void setMacid(String macid) {
        this.macid = macid == null ? null : macid.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getErrortype() {
        return errortype;
    }

    public void setErrortype(String errortype) {
        this.errortype = errortype == null ? null : errortype.trim();
    }

    public String getTreatresult() {
        return treatresult;
    }

    public void setTreatresult(String treatresult) {
        this.treatresult = treatresult == null ? null : treatresult.trim();
    }
}