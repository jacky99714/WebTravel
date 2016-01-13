package model.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.bean.SceneBean;
import model.dao.SceneDAO;
import model.hibernate.HibernateUtil;
import other.bean.FavoriteBean;


public class SceneDAOHibernate implements SceneDAO{
	
	private Session session = null;
	
	public SceneDAOHibernate(Session session){
		this.session = session;
	}
	
	public Session getSession(){
		return session;
	}
	//====================================
	@Override
	public List<SceneBean> select() {
		
		return (List<SceneBean>)getSession().createQuery("from SceneBean").list();
	}

	@Override
	public List<SceneBean> select(String location) {
			
		return (List<SceneBean>)getSession().createQuery("from SceneBean where location='"+location+"'").list();
	}

	@Override
	public List<SceneBean> selectCity(String city) {
		
		return (List<SceneBean>)getSession().createQuery("from SceneBean where city='"+city+"'").list();
	}

	@Override
	public SceneBean selectName(String scenename) {
		
		return (SceneBean)getSession().createQuery("from SceneBean where sceneName='"+scenename+"'").uniqueResult();
	}

	@Override
	public SceneBean insert(SceneBean bean) {
		SceneBean rs = (SceneBean)getSession().get(SceneBean.class,bean.getSceneId());
		if(rs==null){
			getSession().save(bean);
			return bean;
		}		
		return null;
	}

	@Override
	public SceneBean update(SceneBean bean) {
		SceneBean rs = (SceneBean)getSession().load(SceneBean.class,bean.getSceneId());
		if(rs!=null){
			rs.setLocation(bean.getLocation());
			rs.setCity(bean.getCity());
			rs.setSceneName(bean.getSceneName());
			rs.setScenePhoto(bean.getScenePhoto());
			rs.setSceneContent(bean.getSceneContent());
			rs.setTimeStart(bean.getTimeStart());
			rs.setTimeEnd(bean.getTimeEnd());
			rs.setMemberId(bean.getMemberId());
		}
		
		return rs;
	}

	@Override
	public boolean delete(String sceneName) {
		Query query =getSession().createQuery("delete SceneBean where sceneName='"+sceneName+"'");
		query.executeUpdate();
		
		
		return true;
	}

	@Override
	public boolean delete(int sceneId) {
		SceneBean sb = (SceneBean)getSession().get(SceneBean.class,sceneId);
		if(sb != null){
			getSession().delete(sb);
			return true;
		}
		return false;
	}

	@Override
	public SceneBean select(int sceneId) {
		
		return (SceneBean)getSession().get(SceneBean.class,sceneId);
	}

	
	
    //以下3個無使用==============================================
	@Override
	public List<FavoriteBean> selectf(String location) {
		
		return null;
	}

	@Override
	public List<FavoriteBean> selectCityf(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FavoriteBean selectNamef(String scenename) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<SceneBean> select(String location,int begin,int number) {
		Query query = getSession().createQuery("from SceneBean where location='"+location+"'");
		query.setFirstResult(begin);
		query.setMaxResults(number);
		
		return (List<SceneBean>)query.list();
	}
    //===================================================
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			SceneDAO dao = new SceneDAOHibernate(session);
		
			//select All
//			String s = "台北101";
//			SceneBean beans = dao.selectName(s);
//			System.out.println(beans);
			//select One
		    SceneBean bean = dao.select(1);
			System.out.println(bean);
			//delete
//			boolean delete = dao.delete("101xx");
			
//			System.out.println(delete);
			//insert
//			SceneBean insert = new SceneBean();
////			insert.setSceneId(1513);
//			insert.setLocation(s);
//			insert.setCity("台北市");
//			insert.setSceneName("101");
//			insert.setSceneContent("xxxxxxxxxxxxxxxxx");
//			insert.setTimeStart("0800");
//			insert.setTimeEnd("1800");
//			insert.setMemberId(1);
//			insert = dao.insert(insert);
//			System.out.println(insert);
			//update
//			insert = dao.update(insert);
//			System.out.println(insert);
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
