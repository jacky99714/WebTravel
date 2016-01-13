package model.dao;

import java.util.List;

import model.bean.SceneImgBean;

public interface SceneImgDAO {

	// 查詢 SELECT_ALL
	List<SceneImgBean> select();

	// 查詢SELECT_BY_SCENEID
	List<SceneImgBean> select(int sceneId);

	// 新增INSERT
	SceneImgBean insert(SceneImgBean bean);

	// 修改UPDATE
	SceneImgBean update(SceneImgBean bean);

	// 刪除DELETE
	boolean delete(int sceneImgId);

}