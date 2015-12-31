package model.service;

import java.util.List;

import model.bean.SceneBean;
import model.bean.ScheduleBean;
import model.bean.ScheduleContentBean;
import model.dao.CollectDAO;
import model.dao.SceneDAO;
import model.dao.jndi.CollectDAOjndi;
import model.dao.jndi.SceneDAOjndi;
import other.bean.FavoriteBean;
import other.bean.MyScheduleBean;

public class PlanService {
//	 private static final String sql =
//	"select top 1 s.SceneName from Collect as c, Scene as s where c.MemberID=? and c.SceneID = s.SceneID";  

	 private CollectDAO collectDao = new CollectDAOjndi();
	 private SceneDAO sceneDao = new SceneDAOjndi();
	 
	 public List<FavoriteBean> getFavorite(int memberId){
		 return collectDao.selectScene(memberId);		 
	 }
	 
	 public List<FavoriteBean> getScene(String location){
		 if("北區".equals(location) || "中區".equals(location) || "南區".equals(location) || "東區".equals(location)){
			 return sceneDao.select(location);
		 }else{
			 return null;
		 }	 
	 }
	 
//	 public void insertSchedule(){
//		 MyScheduleBean bean = new  MyScheduleBean();
//		 ScheduleBean sb = new ScheduleBean();
//		 ScheduleContentBean scheduleContentBean = new ScheduleContentBean();
//		 sb.setMemberId(memberId);
//		 sb.setScheduleName(scheduleName);
//	 }
}
