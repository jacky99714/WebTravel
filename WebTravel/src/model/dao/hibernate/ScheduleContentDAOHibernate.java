package model.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import model.bean.ScheduleBean;
import model.bean.ScheduleContentBean;
import model.dao.ScheduleContentDAO;
import model.hibernate.HibernateUtil;

public class ScheduleContentDAOHibernate implements ScheduleContentDAO{

	private Session session;
	public ScheduleContentDAOHibernate(Session session){
		this.session = session;
	}
	
	public Session getSession(){
		return session;
	}
	public static void main(String[] args){
		try {
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//			ScheduleContentDAOHibernate sDAO = new ScheduleContentDAOHibernate(session);
////			System.out.println(sDAO.select());
//			sDAO.delete(1);
//			
//			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
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
	public boolean delete(int scheduleId) {
		getSession().createQuery("delete ScheduleContentBean where scheduleId = :sss").setParameter("sss", scheduleId).executeUpdate();
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
		String query = "from ScheduleContentBean where scheduleId = :sss order by ScheduleOrder";
		return (List<ScheduleContentBean>)getSession().createQuery(query).setParameter("sss", scheduleID).list();	
	}

}
