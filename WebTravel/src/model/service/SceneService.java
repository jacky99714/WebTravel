package model.service;

import java.util.List;

import model.bean.SceneBean;
import model.dao.SceneDAO;
import model.dao.jndi.SceneDAOjndi;
import other.bean.FavoriteBean;

public class SceneService {

	private SceneDAO sceneDao = new SceneDAOjndi();
	
	//搜尋區域
	public List<FavoriteBean> getLocation(String location) {
		if (location != null) {
			return sceneDao.select(location);
		}
		return null;
	}
}
