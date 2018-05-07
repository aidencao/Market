package cn.market.pojo;

public class GoodsReturn {
	
	private CustomOrderDetail customOrderDetail;
	
	private String goodsName;
	
	private String goodsSpec;
	
	private String goodsUnit;

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public String getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public CustomOrderDetail getCustomOrderDetail() {
		return customOrderDetail;
	}

	public void setCustomOrderDetail(CustomOrderDetail customOrderDetail) {
		this.customOrderDetail = customOrderDetail;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

}
