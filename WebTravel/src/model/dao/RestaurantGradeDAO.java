package model.dao;

import java.util.List;

import model.RestaurantGradeBean;

public interface RestaurantGradeDAO {

	List<RestaurantGradeBean> select();

	List<RestaurantGradeBean> select(int restaurantId);

	List<RestaurantGradeBean> insert(RestaurantGradeBean restaurantGradeBean);

	List<RestaurantGradeBean> update(RestaurantGradeBean restaurantGradeBean);

	boolean delete(int memberId, int restaurantId);

}