package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SceneMessage")
public class SceneMessageBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sceneMessageId;

	private String messageContent;

	private int memberId;
	
	private int sceneId;
	

	@Override
	public String toString() {
		return "SceneMessageBean [sceneMessageId=" + sceneMessageId + ", messageContent=" + messageContent
				+ ", memberId=" + memberId + ", sceneId=" + sceneId + "]";
	}

	public int getSceneMessageId() {
		return sceneMessageId;
	}

	public void setSceneMessageId(int sceneMessageId) {
		this.sceneMessageId = sceneMessageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;

	}

	
}
