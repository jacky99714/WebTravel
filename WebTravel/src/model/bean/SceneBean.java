package model.bean;

import java.util.Arrays;

public class SceneBean implements java.io.Serializable{

	private int sceneId;

	private String location;

	private String city;

	private String sceneName;
	
	private byte[] scenePhoto;

	public byte[] getScenePhoto() {
		return scenePhoto;
	}

	public void setScenePhoto(byte[] scenePhoto) {
		this.scenePhoto = scenePhoto;
	}

	private String sceneContent;

	private String timeStart;

	private String timeEnd;
	
	private int memberId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + memberId;
		result = prime * result + ((sceneContent == null) ? 0 : sceneContent.hashCode());
		result = prime * result + sceneId;
		result = prime * result + ((sceneName == null) ? 0 : sceneName.hashCode());
		result = prime * result + Arrays.hashCode(scenePhoto);
		result = prime * result + ((timeEnd == null) ? 0 : timeEnd.hashCode());
		result = prime * result + ((timeStart == null) ? 0 : timeStart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SceneBean other = (SceneBean) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (memberId != other.memberId)
			return false;
		if (sceneContent == null) {
			if (other.sceneContent != null)
				return false;
		} else if (!sceneContent.equals(other.sceneContent))
			return false;
		if (sceneId != other.sceneId)
			return false;
		if (sceneName == null) {
			if (other.sceneName != null)
				return false;
		} else if (!sceneName.equals(other.sceneName))
			return false;
		if (!Arrays.equals(scenePhoto, other.scenePhoto))
			return false;
		if (timeEnd == null) {
			if (other.timeEnd != null)
				return false;
		} else if (!timeEnd.equals(other.timeEnd))
			return false;
		if (timeStart == null) {
			if (other.timeStart != null)
				return false;
		} else if (!timeStart.equals(other.timeStart))
			return false;
		return true;
	}

	public String toString() {
		return  "["+sceneId + "," +location + "," + city + ","
				+ sceneName + "," + sceneContent + "," + timeStart + "," + timeEnd
				+ "," + memberId +"]";
	}
	
	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
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
