package model.service;

import java.util.ArrayList;
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
		
//		SceneMessageBean rs = scenemessage.insert(bean);
//		int i = rs.getSceneMessageId();
//		SceneMessageBean rss = scenemessage.selectid(i);
//		System.out.println("select by MID:"+rss);
//		return rss;
		return scenemessage.insert(bean);			
	}
	
	//select by id
	public List<SceneMessageBean> selectmessage(int sceneId){
		List<SceneMessageBean> list = new ArrayList<SceneMessageBean>(scenemessage.select(sceneId));
//		System.out.println(list);
		return list;			
	}
	
}
