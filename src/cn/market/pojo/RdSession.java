package cn.market.pojo;

public class RdSession {
    private String rdsession;

    private String openid;

    private String sessionkey;

    public String getRdsession() {
        return rdsession;
    }

    public void setRdsession(String rdsession) {
        this.rdsession = rdsession == null ? null : rdsession.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey == null ? null : sessionkey.trim();
    }
}