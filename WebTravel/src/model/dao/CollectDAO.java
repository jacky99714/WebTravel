package model.dao;

import java.util.List;

import model.bean.CollectBean;

public interface CollectDAO {

	List<CollectBean> select();

	//會員對景點做收藏 把一個會員收藏的景點查詢出來
	List<CollectBean> select(int memberId);

	List<CollectBean> insert(CollectBean collectBean);

	List<CollectBean> update(CollectBean collectBean);
	
	List<String> selectScene(int memberId);
	

	boolean delete(int memberId, int sceneId);

}