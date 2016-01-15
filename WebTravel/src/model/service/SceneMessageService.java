package model.service;

import java.util.List;

import org.hibernate.Session;

import model.bean.SceneMessageBean;

import model.dao.SceneMessageDAO;

import model.dao.hibernate.SceneMessageDAOHibernate;

import model.hibernate.HibernateUtil;

public class SceneMessageService {

	
private SceneMessageDAO scenemessage ;
	
public SceneMessageService(){
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	scenemessage =  new SceneMessageDAOHibernate(session);
	
}
	
	//insert
	public SceneMessageBean insertmessage(SceneMessageBean bean){	 	
		return scenemessage.insert(bean);			
	}
	
	//select by id
	public List<SceneMessageBean> selectmessage(int sceneId){	 	
		return scenemessage.select(sceneId);			
	}
	
}
