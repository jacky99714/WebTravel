package model.service;

import java.util.List;

import model.bean.CollectBean;
import model.dao.CollectDAO;
import model.dao.jndi.CollectDAOjndi;

public class AddFavoriteService {
	CollectDAO collectdao = new CollectDAOjndi();
	//新增收藏
	public List<CollectBean> addFavorite(CollectBean cBean) {
		if (cBean != null) {
			return collectdao.insert(cBean);
		}
		return null;
		
		 
	}
	
	
	
}
