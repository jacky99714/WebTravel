package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ScheduleContent")
public class ScheduleContentBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int scheduleContentId;
	private int scheduleOrder;
	private int sceneId;
	private int scheduleId;
	
//	@ManyToOne
//	@JoinColumn(name="scheduleId",
//				referencedColumnName="scheduleId",
//				insertable=false,updatable=false
//	)	
//	private ScheduleBean schedule;
	
	
	@Override
	public String toString() {
		return "[行程內容id："+ scheduleContentId + ",行程順序：" + scheduleOrder
				+ ",景點id：" + sceneId + ",行程id：" + scheduleId + "]";
	}
	public int getScheduleContentId() {
		return scheduleContentId;
	}
	public void setScheduleContentId(int scheduleContentId) {
		this.scheduleContentId = scheduleContentId;
	}
	public int getScheduleOrder() {
		return scheduleOrder;
	}
	public void setScheduleOrder(int scheduleOrder) {
		this.scheduleOrder = scheduleOrder;
	}
	public int getSceneId() {
		return sceneId;
	}
	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
	
}
