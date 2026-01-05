package web.com.springweb.z01_dto;
// web.com.springweb.z01_dto.IdoleGroup
public class IdoleGroup {
	private int groupId;
	private String groupName;
	private String agency;
	private String debutSong;
	private String members;
	public IdoleGroup() {
		// TODO Auto-generated constructor stub
	}
	public IdoleGroup(int groupId, String groupName, String agency, String debutSong, String members) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.agency = agency;
		this.debutSong = debutSong;
		this.members = members;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getDebutSong() {
		return debutSong;
	}
	public void setDebutSong(String debutSong) {
		this.debutSong = debutSong;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	
}
