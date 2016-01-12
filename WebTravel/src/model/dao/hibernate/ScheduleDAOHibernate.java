package model.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import model.bean.MemberBean;
import model.bean.QBean;
import model.bean.ScheduleBean;
import model.dao.ScheduleDAO;

public class ScheduleDAOHibernate implements ScheduleDAO{
	private Session session;
	
	public ScheduleDAOHibernate(Session session) {
		super();
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}	
	
	@Override
	public ScheduleBean select(int scheduleId) {
		return (ScheduleBean) getSession().get(ScheduleBean.class, scheduleId);
	}

	@Override
	public List<ScheduleBean> select() {
		return (List<ScheduleBean>) getSession().createQuery("from ScheduleBean").list();
	}

	@Override
	public boolean insert(ScheduleBean scheduleBean) {
		ScheduleBean result = (ScheduleBean) getSession().get(ScheduleBean.class, scheduleBean.getScheduleId());
		if(result == null){
			getSession().save(scheduleBean);
			return true;
		}
		return false;
	}

	@Override
	public ScheduleBean update(ScheduleBean scheduleBean) {
		ScheduleBean result = (ScheduleBean) getSession().get(ScheduleBean.class, scheduleBean.getScheduleId());
		if(result != null){
			result.setMemberId(scheduleBean.getMemberId());
			result.setScheduleId(scheduleBean.getScheduleId());
			result.setScheduleName(scheduleBean.getScheduleName());
		}
		return result;
	}

	@Override
	public boolean delete(int scheduleId) {
		ScheduleBean result = (ScheduleBean)getSession().get(ScheduleBean.class,scheduleId);
		if(result != null){
			getSession().delete(result);
			return true;
		}
		return false;
	}

	@Override
	public int getInsertId(ScheduleBean scheduleBean) {
		ScheduleBean result = (ScheduleBean)getSession().get(ScheduleBean.class, scheduleBean.getScheduleId());
		if(result == null){
			getSession().save(scheduleBean);
		}
		return result.getScheduleId();
	}

	@Override
	public List<ScheduleBean> selectMember(int MemberId) {
		String query = "from ScheduleBean where memberId = ?";
		return (List<ScheduleBean>)getSession().createQuery(query).setInteger(0, MemberId).list();
	}

}
