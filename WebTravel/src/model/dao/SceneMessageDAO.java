package model.dao;

import java.util.List;

import model.bean.SceneMessageBean;

public interface SceneMessageDAO {

	//查詢 SELECT_ALL
	List<SceneMessageBean> select();

	//查詢SELECT_BY_SCENEID
	List<SceneMessageBean> select(int sceneId);

	//新增INSERT
	SceneMessageBean insert(SceneMessageBean bean);

	//修改UPDATE
	SceneMessageBean update(SceneMessageBean bean);

	//刪除DELETE
	boolean delete(int sceneMessageId);

}