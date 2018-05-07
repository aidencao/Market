package cn.market.pojo;

public class Returndata {
	
	String code;
	Object data;
	String message;
	public String getCode() {
		return code;
	}
	public Returndata(String code, Object data, String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
