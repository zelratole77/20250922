package web.com.springweb.a06_ajax_mvc.dto;

public class LunchMenu {
	// menuId category menuName priceTag commentMsg
	// 아이디   분뉴       메뉴명     가격태그   평가태그
	
	private int menuId;
	private String category;
	private String menuName;
	private String priceTag;
	private String commentMsg;
	public LunchMenu() {
		// TODO Auto-generated constructor stub
	}
	public LunchMenu(int menuId, String category, String menuName, String priceTag, String commentMsg) {
		this.menuId = menuId;
		this.category = category;
		this.menuName = menuName;
		this.priceTag = priceTag;
		this.commentMsg = commentMsg;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getPriceTag() {
		return priceTag;
	}
	public void setPriceTag(String priceTag) {
		this.priceTag = priceTag;
	}
	public String getCommentMsg() {
		return commentMsg;
	}
	public void setCommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}
	
}
