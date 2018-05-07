package cn.market.pojo;

public class SortingItem {
	@Override
	public String toString() {
		return "SortingItem [goodsid=" + goodsid + ", goodsname=" + goodsname
				+ ", goodsspec=" + goodsspec + ", goodsunit=" + goodsunit
				+ ", boxnum=" + boxnum + ", num=" + num + ", note=" + note
				+ "]";
	}

	private Integer goodsid;
	private String goodsname;
	private String goodsspec;
	private String goodsunit;
	private Integer boxnum;
	private Integer num;
	private String note;

	public Integer getBoxnum() {
		return boxnum;
	}

	public void setBoxnum(Integer boxnum) {
		this.boxnum = boxnum;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getGoodsspec() {
		return goodsspec;
	}

	public void setGoodsspec(String goodsspec) {
		this.goodsspec = goodsspec;
	}

	public String getGoodsunit() {
		return goodsunit;
	}

	public void setGoodsunit(String goodsunit) {
		this.goodsunit = goodsunit;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
