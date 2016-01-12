package model.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.Session;

import model.bean.SceneBean;
import model.dao.SceneDAO;
import model.dao.hibernate.SceneDAOHibernate;
import model.hibernate.HibernateUtil;
import model.util.TypeConveter;
import other.bean.FavoriteBean;

public class SceneService {

	
	private SceneDAO sceneDao ;
	
	public SceneService(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		sceneDao =  new SceneDAOHibernate(session);
		
	}
	//private SceneDAO sceneDao = new SceneDAOjndi();
	
	//搜尋區域
//	public List<FavoriteBean> getLocation(String location) {
//		if (location != null) {
//			
//			List<FavoriteBean> lilo = sceneDao.selectf(location);
//			 
//			for(FavoriteBean fbean:lilo){
//				if(fbean.getSceneContent().length()>=70L){
//					String str= fbean.getSceneContent().substring(0,70);
//					fbean.setSceneContent(str+"...");
//				}
//			}
//			
//			return lilo;
//		}
//		return null;
//	}
	public List<SceneBean> getLocation(String location) throws UnsupportedEncodingException {
		if (location != null) {
			
			List<SceneBean> lilo = sceneDao.select(location);
			
			
			//取出景點說明前70字
			for(SceneBean fbean:lilo){
				if(fbean.getSceneContent().length()>=70L){
					String str= fbean.getSceneContent().substring(0,70);
					fbean.setSceneContent(str+"...");
				}
			}
			
			return lilo;
		}
		return null;
	}
	//搜尋城市
	public List<FavoriteBean> getCity(String city) {
		if (city != null) {

			List<FavoriteBean> lilo = sceneDao.selectCityf(city);

			for (FavoriteBean fbean : lilo) {
				if (fbean.getSceneContent().length() >= 70L) {
					String str = fbean.getSceneContent().substring(0, 70);
					fbean.setSceneContent(str + "...");
				}
			}

			return lilo;
		}
		return null;
	}
	//搜尋景點
	public FavoriteBean getName(String sceneName) {
		if (sceneName != null) {
			return sceneDao.selectNamef(sceneName);
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
	public boolean deletescene(int sceneId){
		if(sceneId != 0){
			return sceneDao.delete(sceneId);
		}
		return false;
	}  

	
	
	
	
	
}
