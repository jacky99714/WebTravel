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
	//搜尋城市
	public List<FavoriteBean> getCity(String city) {
		if (city != null) {
			return sceneDao.selectCity(city);
		}
		return null;
	}
	
	//搜尋景點
	public FavoriteBean getName(String sceneName) {
		if (sceneName != null) {
			return sceneDao.selectName(sceneName);
		}
		return null;
	}
	//新增景點
	public SceneBean insertscene(SceneBean bean){
		if (bean != null){
			return sceneDao.insert(bean);			
		}
		return null;
	}
	//修改景點
	public SceneBean updatescene(SceneBean bean){
		if (bean != null){
			return sceneDao.update(bean);			
		}
		return null;		
	}

	
	
	
	
	
}
