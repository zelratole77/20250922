package web.com.springweb.z01_dto;

public class NeonSign {
	private String msg;
	private String color;
	private int fontSize;
	public NeonSign() {
		// TODO Auto-generated constructor stub
	}
	public NeonSign(String msg, String color, int fontSize) {
		this.msg = msg;
		this.color = color;
		this.fontSize = fontSize;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
}
