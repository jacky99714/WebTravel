package model.dao;

import java.util.List;

import model.RestaurantBean;

public interface RestaurantDAO {

	// 查詢 SELECT_ALL
	List<RestaurantBean> select();

	// 查詢SELECT_BY_LOCATION
	RestaurantBean select(String location);

	// 新增INSERT
	RestaurantBean insert(RestaurantBean bean);

	// 修改UPDATE
	RestaurantBean update(RestaurantBean bean);

	// 刪除DELETE
	boolean delete(String sceneName);

}