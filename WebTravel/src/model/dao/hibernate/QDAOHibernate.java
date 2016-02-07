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
		QBean result = (QBean)getSession().get(QBean.class, qId);
		if(result != null){
			getSession().delete(result);
		}
		return false;
	}

	@Override
	public QBean insert(QBean qBean) {
		QBean result = (QBean)getSession().get(QBean.class, qBean.getqId());
		if(result == null){
			getSession().save(qBean);
		}
		return null;
	}

	@Override
	public QBean update(QBean qBean) {
		QBean result = (QBean)getSession().get(QBean.class, qBean.getqId());
		if(result != null){
			qBean.setqId(result.getqId());
			qBean.setQName(result.getQName());
			qBean.setA(result.getA());
			qBean.setB(result.getB());
			qBean.setC(result.getC());
			qBean.setD(result.getD());
		}
		return null;
	}

	@Override
	public int getCount() {
		Long count = ((Long) session.createQuery("select count(*) from QBean").uniqueResult());
		return count.intValue();
	}
}
