package model.service;

import model.bean.SceneMessageBean;
import model.dao.SceneMessageDAO;
import model.dao.jndi.SceneMessageDAOjndi;

public class SceneMessageService {

	SceneMessageDAO scenemessage = new SceneMessageDAOjndi();
	
	public SceneMessageBean insertmessage(SceneMessageBean bean){
		 
		
		return scenemessage.insert(bean);
				
	}
}
