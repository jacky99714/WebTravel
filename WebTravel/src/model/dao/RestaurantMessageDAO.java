package model.dao;

import java.util.List;

import model.bean.RestaurantMessageBean;

public interface RestaurantMessageDAO {

	// 查詢 SELECT_ALL
	List<RestaurantMessageBean> select();

	// 查詢SELECT_BY_RESTAURANTID
	RestaurantMessageBean select(int sceneId);

	// 新增INSERT
	RestaurantMessageBean insert(RestaurantMessageBean bean);

	// 修改UPDATE
	RestaurantMessageBean update(RestaurantMessageBean bean);

	// 刪除DELETE
	boolean delete(int RestaurantMessageId);

}