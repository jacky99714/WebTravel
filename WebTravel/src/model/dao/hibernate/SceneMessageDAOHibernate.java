package model.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import model.bean.SceneBean;
import model.bean.SceneImgBean;
import model.bean.SceneMessageBean;
import model.dao.SceneMessageDAO;
import model.hibernate.HibernateUtil;

public class SceneMessageDAOHibernate implements SceneMessageDAO{
	
private Session session = null;
	
	public SceneMessageDAOHibernate(Session session){
		this.session = session;
	}
	
	public Session getSession(){
		return session;
	}
	//====================================
	@Override
	public List<SceneMessageBean> select() {
		
		return (List<SceneMessageBean>)getSession().createQuery("from SceneMessageBean").list();
	}

	@Override
	public List<SceneMessageBean> select(int sceneId) {
		
		return (List<SceneMessageBean>)getSession().createQuery("from SceneMessageBean where sceneId='"+sceneId+"'").list();
	}

	@Override
	public SceneMessageBean insert(SceneMessageBean bean) {
		SceneMessageBean smb = (SceneMessageBean)getSession().get(SceneMessageBean.class, bean.getSceneMessageId());
		if(smb == null){
			getSession().save(bean);
			return smb;
		}
		return null;
	}

	@Override
	public SceneMessageBean update(SceneMessageBean bean) {
		SceneMessageBean smb = (SceneMessageBean)getSession().load(SceneMessageBean.class,bean.getSceneMessageId());
		if(smb != null){
			smb.setSceneMessageId(bean.getSceneMessageId());
			smb.setMessageContent(bean.getMessageContent());
			smb.setMemberId(bean.getMemberId());
			smb.setSceneId(bean.getSceneId());
		}
			
		return smb;
	}

	@Override
	public boolean delete(int sceneMessageId) {
		SceneMessageBean sb = (SceneMessageBean)getSession().get(SceneMessageBean.class,sceneMessageId);
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

			SceneMessageDAOHibernate dao = new SceneMessageDAOHibernate(session);
//			List<SceneMessageBean> beans = dao.select();
//			System.out.println(beans);
			
//			List<SceneMessageBean> bean = dao.select(1);
//			System.out.println(bean);
			
			boolean delete = dao.delete(1);
			System.out.println(delete);
//			
//			SceneMessageBean insert = new SceneMessageBean();
//			
//			insert.setSceneMessageId(1);
//			insert.setMessageContent("oooooooo");
//			insert.setMemberId(1);
//			insert.setSceneId(1);
			
//			
//			insert = dao.insert(insert);
//			System.out.println(insert);
//			
//			insert = dao.update(insert);
//			System.out.println(insert);
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
