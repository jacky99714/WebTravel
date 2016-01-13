package model.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import model.bean.ThoughtBean;
import model.dao.ThoughtDAO;
import model.hibernate.HibernateUtil;
import model.util.TypeConveter;

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
			System.out.println(dao.select(1));
			
			ThoughtBean insert = new ThoughtBean();
			insert.setThoughtId(19);
			insert.setThoughtName("爽玩南投三日");
			insert.setThoughtSubtitle("碧綠日月潭");
			insert.setThoughtContent("好玩*100");
//			insert.setThoughtTime(TypeConveter.parseTimestamp(1991-11-22 16:31:09.510));
			insert.setMemberId(1);
			insert = dao.insert(insert);
			System.out.println(insert);
			
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
		return (List<ThoughtBean>)getSession().createQuery(thoughtName).list();
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
		thoughtBean.setThoughtTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		return (ThoughtBean) getSession().get(ThoughtBean.class, getSession().save(thoughtBean));
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
