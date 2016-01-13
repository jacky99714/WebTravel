package model.dao;

import java.util.List;

import model.bean.SceneBean;
import other.bean.FavoriteBean;

public interface SceneDAO {

	//查詢 SELECT_ALL
	List<SceneBean> select();  

	//查詢SELECT_BY_LOCATION
	List<SceneBean> select(String location);
	
	List<FavoriteBean> selectf(String location);
	
	//查詢SELECT_BY_CITY
	List<SceneBean> selectCity(String city);
	
	List<FavoriteBean> selectCityf(String city);
	
	//查詢SELECT_BY_NAME
	SceneBean selectName(String scenename);
	
	FavoriteBean selectNamef(String scenename);

	//新增INSERT
	SceneBean insert(SceneBean bean);

	//修改UPDATE
	SceneBean update(SceneBean bean);

	//刪除DELETE(景點名稱)
	boolean delete(String sceneName);
	
	//刪除DELETE(景點流水號)
	boolean delete(int sceneId);

	SceneBean select(int sceneId);

	List<SceneBean> select(String location, int begin, int number);

}