package model.dao;

import java.util.List;

import model.RestaurantImgBean;

public interface RestaurantImgDAO {

	// 查詢 SELECT_ALL
	List<RestaurantImgBean> select();

	// 查詢SELECT_BY_RESTAURANTID
	RestaurantImgBean select(int RestaurantId);

	// 新增INSERT
	RestaurantImgBean insert(RestaurantImgBean bean);

	// 修改UPDATE
	RestaurantImgBean update(RestaurantImgBean bean);

	// 刪除DELETE
	boolean delete(int RestaurantImgId);

}