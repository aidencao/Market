package cn.market.pojo;

public class GoodsType {
    private Integer goodstypeid;

    private String goodsname;

    private String goodsunit;

    private String goodsspec;

    private Integer purducerid;

    private Double saleprice;

    private Integer validdays;

    private String other;

    private String pic;

    public Integer getGoodstypeid() {
        return goodstypeid;
    }

    public void setGoodstypeid(Integer goodstypeid) {
        this.goodstypeid = goodstypeid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodsunit() {
        return goodsunit;
    }

    public void setGoodsunit(String goodsunit) {
        this.goodsunit = goodsunit == null ? null : goodsunit.trim();
    }

    public String getGoodsspec() {
        return goodsspec;
    }

    public void setGoodsspec(String goodsspec) {
        this.goodsspec = goodsspec == null ? null : goodsspec.trim();
    }

    public Integer getPurducerid() {
        return purducerid;
    }

    public void setPurducerid(Integer purducerid) {
        this.purducerid = purducerid;
    }

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public Integer getValiddays() {
        return validdays;
    }

    public void setValiddays(Integer validdays) {
        this.validdays = validdays;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}