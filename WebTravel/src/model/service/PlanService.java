package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import model.bean.SceneBean;
import model.bean.ScheduleBean;
import model.bean.ScheduleContentBean;
import model.dao.CollectDAO;
import model.dao.SceneDAO;
import model.dao.ScheduleContentDAO;
import model.dao.ScheduleDAO;
import model.dao.hibernate.ScheduleContentDAOHibernate;
import model.dao.hibernate.ScheduleDAOHibernate;
import model.dao.jndi.CollectDAOjndi;
import model.dao.jndi.SceneDAOjndi;
import model.dao.jndi.ScheduleContentDAOjndi;
import model.dao.jndi.ScheduleDAOjndi;
import model.hibernate.HibernateUtil;
import model.util.TypeConveter;
import other.bean.FavoriteBean;

public class PlanService {
//	 private static final String sql =
//	"select top 1 s.SceneName from Collect as c, Scene as s where c.MemberID=? and c.SceneID = s.SceneID";  
	

	 private CollectDAO collectDao;
	 private SceneDAO sceneDao;
	 private Session session;
	 
	 public PlanService(Session session){
		 this.session = session;
	 }
	 
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

	 public FavoriteBean getScene(int id){
		 SceneBean bean;
		 bean = sceneDao.select(id);
		 return TypeConveter.parseFavoriteBean(bean);
	 }
	 
	 public List<FavoriteBean> getSchedule(List<Integer> li){
		 List<FavoriteBean> fav = new ArrayList<>();
		 for(int key:li){
			 fav.add(getScene(key));
		 }
		 return fav;
	 }
	 public void insertSchedule(JSONArray jsonArr){

    	 if(jsonArr.length() < 1){
			 return;
		 }
		 ScheduleBean scheduleBean = getScheduleBean(jsonArr);
		 ScheduleContentBean []contentBean = new ScheduleContentBean[jsonArr.length()];
		 ScheduleContentDAO dao = new ScheduleContentDAOHibernate(session); 	
		 int scheduleId = scheduleBean.getScheduleId();
		 for(int i = 0; i < jsonArr.length();i++){
			contentBean[i] = new ScheduleContentBean();
			JSONObject jsonObj =  jsonArr.getJSONObject(i);
			//System.out.println("jsonObj.getString" +jsonObj.getString("sceneId"));
			contentBean[i].setSceneId(jsonObj.getInt("sceneId"));
			contentBean[i].setScheduleId(scheduleId);
			contentBean[i].setScheduleOrder(jsonObj.getInt("scheduleOrder"));
			dao.insert(contentBean[i]);
		 }	
	 }
	 
	 private ScheduleBean getScheduleBean(JSONArray jsonArr){
		 JSONObject jsonObj =  jsonArr.getJSONObject(0);
		 ScheduleBean bean = new ScheduleBean();
		 bean.setMemberId(jsonObj.getInt("memberId"));
		 bean.setScheduleName(jsonObj.getString("scheduleName"));
		 ScheduleDAO dao = new ScheduleDAOHibernate(session);
		 int id = dao.getInsertId(bean);
		 bean.setScheduleId(id);
		 return bean;
	 }
}
