package web.com.springweb.a02_mvc.a02_Meet;

import java.util.Date;

public class A04Meet {
	private int dateNo;
	private String partnerName;
	private int partnerAge;
	private String job;
	private String location;
	private Date meetDate;
	private String status;
	private int score;
	private String review;
	public A04Meet() {
		// TODO Auto-generated constructor stub
	}
	
	public A04Meet(int dateNo, String partnerName, int partnerAge, String job, String location, Date meetDate,
			String status, int score, String review) {
		this.dateNo = dateNo;
		this.partnerName = partnerName;
		this.partnerAge = partnerAge;
		this.job = job;
		this.location = location;
		this.meetDate = meetDate;
		this.status = status;
		this.score = score;
		this.review = review;
	}

	
	public int getDateNo() {
		return dateNo;
	}
	public void setDateNo(int dateNo) {
		this.dateNo = dateNo;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public int getPartnerAge() {
		return partnerAge;
	}
	public void setPartnerAge(int partnerAge) {
		this.partnerAge = partnerAge;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
}
