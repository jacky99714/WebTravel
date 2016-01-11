package model.dao.Hibernate;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.hibernate.Session;

import model.bean.Collect;
import model.bean.CollectBean;
import model.bean.CollectId;
import model.bean.Scene;
import model.dao.CollectDAO;
import model.hibernate.HibernateUtil;
import other.bean.FavoriteBean;

public class CollectDAOHibernate implements CollectDAO{
	private Session session;
	
	public CollectDAOHibernate(Session session) {
		super();
		this.session=session;
	}
	
	public Session getSession() {
		return session;
	}

	public static void main(String[] args) {
		CollectBean bean = new CollectBean();
		bean.setCollectId(1);
		bean.setMemberId(1);
		bean.setSceneId(42);
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			CollectDAOHibernate cDAO = new CollectDAOHibernate(session);
			
			//select
//			System.out.println(cDAO.select(1));
			
			
			//insert
//			System.out.println(cDAO.selectScene(1));
			
			//delete
//			System.out.println(cDAO.delete(1,4));
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	
	
	@Override
	public List<CollectBean> select() {
		List<Collect> collectlist = (List<Collect>)getSession().createQuery("from Collect").list();
		if(!collectlist.isEmpty()){
			List<CollectBean> list = new ArrayList<CollectBean>();
			for(Collect collect:collectlist){
				CollectBean bean =new CollectBean();
				bean.setCollectId(collect.getCollectId());
				bean.setMemberId(collect.getId().getMemberId());
				bean.setSceneId(collect.getId().getSceneId());
				list.add(bean);
			}
			return list;
		}
		return null;
	}

	@Override
	public List<CollectBean> select(int memberId) {
		List<Collect> collectlist = (List<Collect>)getSession().createQuery("from Collect where memberId ='"+memberId+"'").list();
		if(!collectlist.isEmpty()){
			List<CollectBean> list = new ArrayList<CollectBean>();
			for(Collect collect:collectlist){
				CollectBean bean =new CollectBean();
				bean.setCollectId(collect.getCollectId());
				bean.setMemberId(collect.getId().getMemberId());
				bean.setSceneId(collect.getId().getSceneId());
				list.add(bean);
			}
			return list;
		}
		return null;
	}

	@Override
	public List<CollectBean> insert(CollectBean collectBean) {
		if(collectBean!=null){
			Collect collect = new Collect();
			CollectId collectId = new CollectId();
			collectId.setMemberId(collectBean.getMemberId());
			collectId.setSceneId(collectBean.getSceneId());
			collect.setId(collectId);
			collect.setCollectId(collectBean.getCollectId());
			CollectId id =(CollectId)getSession().save(collect);
			return this.select(id.getMemberId());
		}
		return null;
	}

	@Override
	public List<CollectBean> update(CollectBean collectBean) {
		
		return null;
	}

	@Override
	public List<FavoriteBean> selectScene(int memberId) {
		List<CollectBean> listC = this.select(memberId);
		List<FavoriteBean> favoriteBeans = new ArrayList<FavoriteBean>();
		for(CollectBean collectBean:listC){
			FavoriteBean bean = new FavoriteBean();
			Scene scene =(Scene)getSession().load(Scene.class, collectBean.getSceneId());
			bean.setCity(scene.getCity());
			bean.setLocation(scene.getLocation());
			bean.setMemberId(scene.getMember().getMemberId());
			bean.setSceneContent(scene.getSceneContent());
			bean.setSceneId(scene.getSceneId());
			bean.setSceneName(scene.getSceneName());
			bean.setScenePhoto(Base64.getEncoder().encodeToString(scene.getScenePhoto()));
			bean.setTimeEnd(scene.getTimeEnd());
			bean.setTimeStart(scene.getTimeStart());
			favoriteBeans.add(bean);
		}
		return favoriteBeans;
	}
	@Override
	public boolean delete(int memberId, int sceneId) {
		CollectId collectId = new CollectId();
		collectId.setMemberId(memberId);
		collectId.setSceneId(sceneId);
		Collect collect = new Collect();
		collect.setId(collectId);
		getSession().delete(collect);
		Collect c =(Collect)getSession().get(Collect.class,collectId);
		if(c==null){
			return true;
		}
		return false;
	}



}
