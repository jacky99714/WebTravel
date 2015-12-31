package other.bean;

import model.bean.ScheduleBean;
import model.bean.ScheduleContentBean;

public class MyScheduleBean {
	private ScheduleBean scheduleBean;
	private ScheduleContentBean scheduleContentBean;
	public ScheduleBean getScheduleBean() {
		return scheduleBean;
	}
	public void setScheduleBean(ScheduleBean scheduleBean) {
		this.scheduleBean = scheduleBean;
	}
	public ScheduleContentBean getScheduleContentBean() {
		return scheduleContentBean;
	}
	public void setScheduleContentBean(ScheduleContentBean scheduleContentBean) {
		this.scheduleContentBean = scheduleContentBean;
	}
	

	
	//取得最近一筆流水號id
	//insert into Schedule(scheduleName,memberId) values('台東一日遊',1);select @@Identity
}
