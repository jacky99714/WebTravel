package model.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import model.bean.SceneBean;
import model.bean.SceneImgBean;
import model.dao.SceneImgDAO;
import model.hibernate.HibernateUtil;

public class SceneImgDAOHibernate implements SceneImgDAO{

	
private Session session = null;
	
	public SceneImgDAOHibernate(Session session){
		this.session = session;
	}
	
	public Session getSession(){
		return session;
	}
	//====================================
	@Override
	public List<SceneImgBean> select() {
		
		return (List<SceneImgBean>)getSession().createQuery("from SceneImgBean").list();
	}

	@Override
	public List<SceneImgBean> select(int sceneId) {
		
		return (List<SceneImgBean>)getSession().createQuery("from SceneImgBean where sceneId='"+sceneId+"'").list();
	}

	@Override
	public SceneImgBean insert(SceneImgBean bean) {
		SceneImgBean sb = (SceneImgBean)getSession().get(SceneImgBean.class,bean.getSceneImgId());
		if(sb == null){
			getSession().save(bean);
			return bean;
		}
		
		return null;
	}

	@Override
	public SceneImgBean update(SceneImgBean bean) {
		SceneImgBean sib = (SceneImgBean)getSession().load(SceneImgBean.class,bean.getSceneImgId());
		if(sib!=null){
			sib.setSceneImgId(bean.getSceneImgId());
			sib.setImg(bean.getImg());
			sib.setSceneId(bean.getSceneId());
			
		}
		return sib;
	}

	@Override
	public boolean delete(int sceneImgId) {
		SceneImgBean sb = (SceneImgBean)getSession().get(SceneImgBean.class,sceneImgId);
		if(sb != null){
			getSession().delete(sb);
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			SceneImgDAOHibernate dao = new SceneImgDAOHibernate(session);
//			List<SceneImgBean> beans = dao.select();
//			System.out.println(beans);
			
//			List<SceneImgBean> bean = dao.select(1);
//			System.out.println(bean);
//			
			boolean delete = dao.delete(3);
			System.out.println(delete);
//			
//			SceneImgBean insert = new SceneImgBean();
//			
//			insert.setSceneId(1);
//			
//			insert = dao.insert(insert);
//			System.out.println(insert);
//			
//			ProductBean update = dao.update("hehehe", 300, new java.util.Date(0), 400, 15);
//			System.out.println(update);
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
