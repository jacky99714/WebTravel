package model.dao.Hibernate;

import java.util.List;

import org.hibernate.Session;

import model.bean.ThoughtBean;
import model.dao.ThoughtDAO;
import model.hibernate.HibernateUtil;

public class ThoughtDAOHibernate implements ThoughtDAO {
	private Session session;
	public ThoughtDAOHibernate(Session session){
		super();
		this.session = session;
	}
	public Session getSession(){
		return session;
	}

	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			ThoughtDAO dao = new ThoughtDAOHibernate(session);
			List<ThoughtBean> beans = dao.select();
			System.out.println(beans);
			System.out.println(dao.select(2));
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}
	@Override
	public List<ThoughtBean> select() {
		return (List<ThoughtBean>)getSession().createQuery("from ThoughtBean").list();
	}

	@Override
	public List<ThoughtBean> select(String thoughtName) {
		return (List<ThoughtBean>)getSession().createQuery("from ThoughtBean where thoughtName='"+thoughtName+"'").list();
	}

	@Override
	public ThoughtBean select(int thoughtId) {
		return (ThoughtBean)getSession().get(ThoughtBean.class, thoughtId);
	}

	@Override
	public ThoughtBean update(ThoughtBean thoughtBean) {
		ThoughtBean result = (ThoughtBean) getSession().get(ThoughtBean.class, thoughtBean.getThoughtId());
		if(result != null){
			result.setThoughtName(thoughtBean.getThoughtName());
			result.setThoughtContent(thoughtBean.getThoughtContent());
			result.setThoughtSubtitle(thoughtBean.getThoughtSubtitle());
			result.setMemberId(thoughtBean.getMemberId());
		}
		return result;
	}

	@Override
	public ThoughtBean insert(ThoughtBean thoughtBean) {
		ThoughtBean result = (ThoughtBean) getSession().get(ThoughtBean.class, thoughtBean.getThoughtId());
		if(result == null){
			getSession().save(thoughtBean);
			return thoughtBean;
		}
		return null;
	}

	@Override
	public boolean delete(int thoughtId) {
		ThoughtBean thoughtBean = (ThoughtBean)getSession().get(ThoughtBean.class, thoughtId);
		if(thoughtBean != null){
			getSession().delete(thoughtBean);
			return true;
		}
		return false;
	}


}
