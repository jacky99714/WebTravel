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
import model.dao.hibernate.CollectDAOHibernate;
import model.dao.hibernate.SceneDAOHibernate;
import model.dao.hibernate.ScheduleContentDAOHibernate;
import model.dao.hibernate.ScheduleDAOHibernate;
import model.hibernate.HibernateUtil;
import model.util.TypeConveter;
import other.bean.FavoriteBean;

public class PlanService {
//	 private static final String sql =
//	"select top 1 s.SceneName from Collect as c, Scene as s where c.MemberID=? and c.SceneID = s.SceneID";  
	

	 private CollectDAO collectDao;
	 private SceneDAO sceneDao;
	 private ScheduleContentDAO scheduleContentDao;
	 private ScheduleDAO scheduleDao;
	 
	 public PlanService(){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			sceneDao = new SceneDAOHibernate(session);
			collectDao = new CollectDAOHibernate(session);
			scheduleDao = new ScheduleDAOHibernate(session);
			scheduleContentDao = new ScheduleContentDAOHibernate(session);
	 }
	 
	 public List<FavoriteBean> getFavorite(int memberId){
		 return collectDao.selectScene(memberId);		 
	 }
	 
	 public List<FavoriteBean> getScene(String location){
		 if("北區".equals(location) || "中區".equals(location) || "南區".equals(location) || "東區".equals(location)){
			 List<SceneBean> li = sceneDao.select(location);
			 List<FavoriteBean> fav = new ArrayList<>();
			 for(SceneBean bean:li){
				 fav.add(TypeConveter.parseFavoriteBean(bean));
			 }
			 return fav;
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
		
		 int scheduleId = scheduleBean.getScheduleId();
		 for(int i = 0; i < jsonArr.length();i++){
			contentBean[i] = new ScheduleContentBean();
			JSONObject jsonObj =  jsonArr.getJSONObject(i);
			//System.out.println("jsonObj.getString" +jsonObj.getString("sceneId"));
			contentBean[i].setSceneId(jsonObj.getInt("sceneId"));
			contentBean[i].setScheduleId(scheduleId);
			contentBean[i].setScheduleOrder(jsonObj.getInt("scheduleOrder"));
			scheduleContentDao.insert(contentBean[i]);
		 }	
	 }
	 
	 private ScheduleBean getScheduleBean(JSONArray jsonArr){
		 JSONObject jsonObj =  jsonArr.getJSONObject(0);
		 ScheduleBean bean = new ScheduleBean();
		 bean.setMemberId(jsonObj.getInt("memberId"));
		 bean.setScheduleName(jsonObj.getString("scheduleName")); 
		 int id = scheduleDao.getInsertId(bean);
		 bean.setScheduleId(id);
		 return bean;
	 }
}
