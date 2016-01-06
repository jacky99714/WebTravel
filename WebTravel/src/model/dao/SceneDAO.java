package model.dao;

import java.util.List;

import model.bean.SceneBean;
import other.bean.FavoriteBean;

public interface SceneDAO {

	//查詢 SELECT_ALL
	List<SceneBean> select();

	//查詢SELECT_BY_LOCATION
	List<FavoriteBean> select(String location);
	
	//查詢SELECT_BY_CITY
	List<FavoriteBean> selectCity(String city);
	
	//查詢SELECT_BY_NAME
	FavoriteBean selectName(String scenename);

	//新增INSERT
	SceneBean insert(SceneBean bean);

	//修改UPDATE
	SceneBean update(SceneBean bean);

	//刪除DELETE
	boolean delete(String sceneName);

}