package other.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SceneImg")
public class SceneImg implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sceneImgId;

	private String img;
	
	private int sceneId;

	public int getSceneImgId() {
		return sceneImgId;
	}

	public void setSceneImgId(int sceneImgId) {
		this.sceneImgId = sceneImgId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
