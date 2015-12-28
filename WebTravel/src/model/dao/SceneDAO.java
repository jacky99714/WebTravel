package model.dao;

import java.util.List;

import model.bean.SceneBean;

public interface SceneDAO {

	//查詢 SELECT_ALL
	List<SceneBean> select();

	//查詢SELECT_BY_LOCATION
	List<SceneBean> select(String location);

	//新增INSERT
	SceneBean insert(SceneBean bean);

	//修改UPDATE
	SceneBean update(SceneBean bean);

	//刪除DELETE
	boolean delete(String sceneName);

}