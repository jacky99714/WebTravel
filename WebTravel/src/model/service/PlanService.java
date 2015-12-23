package model.service;

import java.util.List;


import model.dao.CollectDAO;
import model.dao.jndi.CollectDAOjndi;

public class PlanService {
//	 private static final String sql =
//	"select top 1 s.SceneName from Collect as c, Scene as s where c.MemberID=? and c.SceneID = s.SceneID";  

	 private CollectDAO collectDao = new CollectDAOjndi();
	 public List<String> getFavorite(int memberId){
		 return collectDao.selectScene(memberId);		 
	 }
}
