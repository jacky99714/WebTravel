package model.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Schedule")
public class ScheduleBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int scheduleId;
	private String scheduleName;
	private int memberId;
	
	@OneToMany(
			cascade={
				CascadeType.REMOVE
			}
	)
	@JoinColumn(name="scheduleId")
	private Set<ScheduleContentBean> scheduleContentBeans; 
	
	
	public Set<ScheduleContentBean> getScheduleContentBeans() {
		return scheduleContentBeans;
	}
	public void setScheduleContentBeans(Set<ScheduleContentBean> scheduleContentBeans) {
		this.scheduleContentBeans = scheduleContentBeans;
	}
	@Override
	public String toString() {
		return "[" + scheduleId + "," + scheduleName +","+ memberId + "]";
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	
}
