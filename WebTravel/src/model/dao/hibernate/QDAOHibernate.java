package model.dao.hibernate;



import java.util.List;

import org.hibernate.Session;

import model.bean.QBean;
import model.dao.QDAO;


public class QDAOHibernate implements QDAO{
	
	private Session session;
	public QDAOHibernate(Session session) {
		super();
		this.session = session;
	}
	public Session getSession() {
		return session;
	}

	@Override
	public List<QBean> select() {
		return (List<QBean>) getSession().createQuery("from QBean").list();
	}

	@Override
	public QBean select(String qName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public QBean select(int qId){
		return (QBean) getSession().get(QBean.class, qId);	
	}	

	@Override
	public boolean delete(int qId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QBean insert(QBean qBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QBean update(QBean qBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		Long count = ((Long) session.createQuery("select count(*) from QBean").uniqueResult());
		return count.intValue();
	}
}
