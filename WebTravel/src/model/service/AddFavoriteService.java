package model.service;

import java.util.List;

import org.hibernate.Session;

import model.bean.CollectBean;
import model.dao.CollectDAO;

import model.dao.hibernate.CollectDAOHibernate;

import model.hibernate.HibernateUtil;

public class AddFavoriteService {
private CollectDAO collectdao ;
	
	public AddFavoriteService(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		collectdao =  new CollectDAOHibernate(session);		
	}
	
	//CollectDAO collectdao = new CollectDAOjndi();
	
	//新增收藏
	public List<CollectBean> addFavorite(CollectBean cBean) {
		if (cBean != null) {
			return collectdao.insert(cBean);
		}
		return null;				 
	}
	
	//Select by memberID
	public List<CollectBean> selectMid (int memberId){
		
		return collectdao.select(memberId);
	}
}
