package web.com.springweb.a06_ajax_mvc.dto;

import java.util.Date;

public class GourmetStore {
	private int id;
	private String name;
	private String category;
	private String keyword;
	private int rating;
	private Date createdAt;
	public GourmetStore() {
		// TODO Auto-generated constructor stub
	}
	public GourmetStore(int id, String name, String category, String keyword, int rating, Date createdAt) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.keyword = keyword;
		this.rating = rating;
		this.createdAt = createdAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
