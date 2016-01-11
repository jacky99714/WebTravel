package model.bean;

public class ThoughtBean {
	private int thoughtId;
	private String thoughtName;
	private String thoughtContent;
	private String thoughtSubtitle;
	private java.sql.Timestamp thoughtTime;
	private int memberId;
	
	
	
	@Override
	public String toString() {
		return "[" + thoughtId + "," + thoughtName + "," + thoughtContent + "," 
				+ thoughtSubtitle + "," + thoughtTime + "," + memberId + "]";
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

}
