package web.com.springweb.z01_dto;

public class Lotto {
	private int luckyNum;
	private int price;
	private String msg;
	public Lotto() {
		// TODO Auto-generated constructor stub
	}
	public Lotto(int luckyNum, int price, String msg) {
		this.luckyNum = luckyNum;
		this.price = price;
		this.msg = msg;
	}
	public int getLuckyNum() {
		return luckyNum;
	}
	public void setLuckyNum(int luckyNum) {
		this.luckyNum = luckyNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
