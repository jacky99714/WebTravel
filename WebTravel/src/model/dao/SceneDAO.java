package model.dao;

import java.util.List;

import model.bean.SceneBean;
import other.bean.FavoriteBean;

public interface SceneDAO {

	//查詢 SELECT_ALL
	List<SceneBean> select();  

	//查詢SELECT_BY_LOCATION
	List<FavoriteBean> select(String location);

	//新增INSERT
	SceneBean insert(SceneBean bean);

	//修改UPDATE
	SceneBean update(SceneBean bean);

	//刪除DELETE(景點名稱)
	boolean delete(String sceneName);
	
	//刪除DELETE(景點流水號)
	boolean delete(int sceneId);

}