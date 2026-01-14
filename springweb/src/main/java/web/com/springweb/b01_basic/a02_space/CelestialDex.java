package web.com.springweb.b01_basic.a02_space;

import java.util.Date;

public class CelestialDex {
	private int bodyId;
	private String bodyName;
	private String classification;
	private int distanceLy;
	private Date discoveryDate;
	private String description;
	public CelestialDex() {
		// TODO Auto-generated constructor stub
	}
	public CelestialDex(int bodyId, String bodyName, String classification, int distanceLy, Date discoveryDate,
			String description) {
		this.bodyId = bodyId;
		this.bodyName = bodyName;
		this.classification = classification;
		this.distanceLy = distanceLy;
		this.discoveryDate = discoveryDate;
		this.description = description;
	}
	public int getBodyId() {
		return bodyId;
	}
	public void setBodyId(int bodyId) {
		this.bodyId = bodyId;
	}
	public String getBodyName() {
		return bodyName;
	}
	public void setBodyName(String bodyName) {
		this.bodyName = bodyName;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public int getDistanceLy() {
		return distanceLy;
	}
	public void setDistanceLy(int distanceLy) {
		this.distanceLy = distanceLy;
	}
	public Date getDiscoveryDate() {
		return discoveryDate;
	}
	public void setDiscoveryDate(Date discoveryDate) {
		this.discoveryDate = discoveryDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
