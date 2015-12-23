package model.service;

import java.util.List;

import model.bean.CollectBean;
import model.dao.CollectDAO;
import model.dao.SceneDAO;
import model.dao.SceneImgDAO;
import model.dao.jndi.CollectDAOjndi;
import model.dao.jndi.SceneDAOjndi;
import model.dao.jndi.SceneImgDAOjndi;

public class PlanService {
//	 private static final String sql =
//	"select top 1 s.SceneName from Collect as c, Scene as s where c.MemberID=? and c.SceneID = s.SceneID";  
	 private SceneImgDAO simg = new SceneImgDAOjndi();
	 private SceneDAO scene = new SceneDAOjndi();
	 private CollectDAO collectDao = new CollectDAOjndi();
	 public void getFavorite(int memberId){
		 List<CollectBean> fav = collectDao.selectScene(memberId);
	 }
}
