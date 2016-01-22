package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.bean.SceneImgBean;
import model.dao.SceneDAO;
import model.dao.SceneImgDAO;
import model.dao.hibernate.SceneDAOHibernate;
import model.dao.hibernate.SceneImgDAOHibernate;
import model.hibernate.HibernateUtil;
import model.util.TypeConveter;
import other.bean.SceneImg;

public class SceneImgService {
	
private SceneImgDAO sceneImgDao ;
	
	public SceneImgService(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		sceneImgDao =  new SceneImgDAOHibernate(session);		
	}
	//select 景點圖片	
	public List<SceneImgBean> selectImg (int sceneId){
		
		
		return sceneImgDao.select(sceneId);
	}
	
	//圖轉base64
	public List<SceneImg> change64(List<SceneImgBean> list) {
		List<SceneImg> silist = new ArrayList<>();
		for(SceneImgBean s:list){
			SceneImg sibean = new SceneImg();
			sibean.setSceneImgId(s.getSceneImgId());
			sibean.setSceneId(s.getSceneId());
			sibean.setImg(TypeConveter.EncodeBase64(s.getImg()));
			silist.add(sibean);
		}
		
		return silist;
	}
	
	
}
