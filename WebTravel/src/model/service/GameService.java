package model.service;

import model.bean.QBean;
import model.dao.QDAO;
import model.dao.jndi.QDAOjndi;

public class GameService {
	
	public QBean getQuestion(){
		QDAO q = new QDAOjndi();
		QBean bean =new QBean();
		int index = (int)(Math.random()*q.getCount()+1);
		bean = q.select(index);
		return bean;
	}

}
