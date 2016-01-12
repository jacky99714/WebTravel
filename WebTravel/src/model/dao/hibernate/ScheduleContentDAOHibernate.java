package model.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import model.bean.ScheduleContentBean;
import model.dao.ScheduleContentDAO;

public class ScheduleContentDAOHibernate implements ScheduleContentDAO{

	private Session session;
	public ScheduleContentDAOHibernate(Session session){
		this.session = session;
	}
	
	public Session getSession(){
		return session;
	}
	
	@Override
	public List<ScheduleContentBean> select() {
		return (List<ScheduleContentBean>)getSession().createQuery("from ScheduleContentBean").list();
	}

	@Override
	public ScheduleContentBean select(int scheduleContentId) {
		return (ScheduleContentBean)getSession().get(ScheduleContentBean.class, scheduleContentId);
	}

	@Override
	public boolean insert(ScheduleContentBean scheduleContentBean) {
		ScheduleContentBean result = (ScheduleContentBean)getSession().get(ScheduleContentBean.class,scheduleContentBean.getScheduleContentId());
		if(result == null){
			getSession().save(scheduleContentBean);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int scheduleContentId) {
		ScheduleContentBean result = (ScheduleContentBean)getSession().get(ScheduleContentBean.class,scheduleContentId);
		if(result != null){
			getSession().delete(result);
		}
		return false;
	}

	@Override
	public ScheduleContentBean update(ScheduleContentBean scheduleContentBean) {
		ScheduleContentBean result = (ScheduleContentBean)getSession().get(ScheduleContentBean.class,scheduleContentBean.getScheduleContentId());
		if(result != null){
			result.setScheduleContentId(scheduleContentBean.getScheduleContentId());
			result.setScheduleId(scheduleContentBean.getScheduleId());
			result.setSceneId(scheduleContentBean.getSceneId());
			result.setScheduleOrder(scheduleContentBean.getScheduleOrder());
			return result;
		}
		return null;
	}

	@Override
	public List<ScheduleContentBean> selectSchedule(int scheduleID) {
		String query = "from ScheduleContentBean where scheduleId = ?";
		return (List<ScheduleContentBean>)getSession().createQuery(query).setInteger(0, scheduleID).list();	
	}

}
