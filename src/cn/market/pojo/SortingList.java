package cn.market.pojo;

import java.util.List;

/**
 * @author Cyr
 * 
 */
public class SortingList {
	private String macid;
	private List<SortingItem> list;
	private Integer sum;
	private String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMacid() {
		return macid;
	}

	public void setMacid(String macid) {
		this.macid = macid;
	}

	public List<SortingItem> getList() {
		return list;
	}

	public void setList(List<SortingItem> list) {
		this.list = list;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
}
