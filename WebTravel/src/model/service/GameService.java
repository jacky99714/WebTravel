package model.service;

import org.hibernate.Session;

import model.bean.QBean;
import model.dao.QDAO;
import model.dao.hibernate.QDAOHibernate;
import model.hibernate.HibernateUtil;

public class GameService {
	private QDAO qDao;
	public GameService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		qDao = new QDAOHibernate(session);
	}	
	public QBean getQuestion(){	
		QBean bean =new QBean();
		int index = (int) (Math.random()*qDao.getCount())+1;
		bean = qDao.select(index);
		return bean;
	}

}
