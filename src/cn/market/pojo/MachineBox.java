package cn.market.pojo;

public class MachineBox extends MachineBoxKey {
    private Integer goodstypeid;

    private Integer goodssum;

    private Integer goodsmaxsum;

    private Double rateoutstock;

    public Integer getGoodstypeid() {
        return goodstypeid;
    }

    public void setGoodstypeid(Integer goodstypeid) {
        this.goodstypeid = goodstypeid;
    }

    public Integer getGoodssum() {
        return goodssum;
    }

    public void setGoodssum(Integer goodssum) {
        this.goodssum = goodssum;
    }

    public Integer getGoodsmaxsum() {
        return goodsmaxsum;
    }

    public void setGoodsmaxsum(Integer goodsmaxsum) {
        this.goodsmaxsum = goodsmaxsum;
    }

    public Double getRateoutstock() {
        return rateoutstock;
    }

    public void setRateoutstock(Double rateoutstock) {
        this.rateoutstock = rateoutstock;
    }
}