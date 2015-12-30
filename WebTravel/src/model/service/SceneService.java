package model.service;

import java.util.List;

import model.bean.SceneBean;
import model.dao.SceneDAO;
import model.dao.jndi.SceneDAOjndi;

public class SceneService {

	private SceneDAO sceneDao = new SceneDAOjndi();
	
	//搜尋區域
	public List<SceneBean> getLocation(String location) {
		if (location != null) {
			return sceneDao.select(location);
		}
		return null;
	}
}
