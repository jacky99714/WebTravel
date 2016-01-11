package model.service;

import org.hibernate.Session;

import model.bean.QBean;
import model.dao.QDAO;
import model.dao.jndi.QDAOjndi;
import model.hibernate.HibernateUtil;
import model.hibernate.QDAOHibernate;

public class GameService {
	private QDAO qDao;
	public GameService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		qDao = new QDAOHibernate(session);
	}	
	public QBean getQuestion(){
		QBean bean =new QBean();
	//	int index = (int)(Math.random()*q.getCount()+1);
		bean = qDao.select(1);
		return bean;
	}

}
