package other.bean;

public class MythoughtBean {
	private int thoughtId;
	private String thoughtName;
	private String thoughtContent;
	private String thoughtSubtitle;
	private java.sql.Timestamp thoughtTime;
	private int memberId;
	private String thoughtPhoto;
	
	
	public String toString() {
		return "[" + thoughtId + "," + thoughtName + "," + thoughtSubtitle + "," + thoughtContent + "," 
				+thoughtPhoto+","+ thoughtTime + "," + memberId + "]";
	}
	
	public int getThoughtId() {
		return thoughtId;
	}
	public void setThoughtId(int thoughtId) {
		this.thoughtId = thoughtId;
	}
	public String getThoughtName() {
		return thoughtName;
	}
	public void setThoughtName(String thoughtName) {
		this.thoughtName = thoughtName;
	}
	public String getThoughtContent() {
		return thoughtContent;
	}
	public void setThoughtContent(String thoughtContent) {
		this.thoughtContent = thoughtContent;
	}
	public String getThoughtSubtitle() {
		return thoughtSubtitle;
	}
	public void setThoughtSubtitle(String thoughtSubtitle) {
		this.thoughtSubtitle = thoughtSubtitle;
	}
	public java.sql.Timestamp getThoughtTime() {
		return thoughtTime;
	}
	public void setThoughtTime(java.sql.Timestamp thoughtTime) {
		this.thoughtTime = thoughtTime;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getThoughtPhoto() {
		return thoughtPhoto;
	}
	public void setThoughtPhoto(String thoughtPhoto) {
		this.thoughtPhoto = thoughtPhoto;
	}

}
