package cn.market.pojo;

public class Config {
    private String mallid;

    private String mallname;

    public String getMallid() {
        return mallid;
    }

    public void setMallid(String mallid) {
        this.mallid = mallid == null ? null : mallid.trim();
    }

    public String getMallname() {
        return mallname;
    }

    public void setMallname(String mallname) {
        this.mallname = mallname == null ? null : mallname.trim();
    }
}