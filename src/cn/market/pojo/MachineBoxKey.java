package cn.market.pojo;

public class MachineBoxKey {
    private String macid;

    private Integer boxno;

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
}