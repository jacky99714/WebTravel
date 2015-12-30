package other.bean;

public class FavoriteBean implements java.io.Serializable{

	private String location;
	private String city;
	private String sceneName;
	private String scenePhoto;
	private String sceneContent;
	private String timeStart;
	private String timeEnd;
	private int memberId;

	public String toString() {
		return  "[" +location + "," + city + ","
				+ sceneName + "," +scenePhoto+"," + sceneContent + "," + timeStart + "," + timeEnd
				+ "," + memberId +"]";
	}
	


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}
	
	public String getScenePhoto() {
		return scenePhoto;
	}

	public void setScenePhoto(String scenePhoto) {
		this.scenePhoto = scenePhoto;
	}
	public String getSceneContent() {
		return sceneContent;
	}

	public void setSceneContent(String sceneContent) {
		this.sceneContent = sceneContent;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}


	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


}
