package model.dao;

import java.util.List;

import model.bean.ImpeachBean;

public interface ImpeachDAO {

	boolean delete(int impeachId);

	List<ImpeachBean> insertSceneId(ImpeachBean impeachBean);

	List<ImpeachBean> insertSceneMessageId(ImpeachBean impeachBean);

	List<ImpeachBean> insertThoughtId(ImpeachBean impeachBean);

	List<ImpeachBean> insertRestaurantMessageId(ImpeachBean impeachBean);

	List<ImpeachBean> insertRestaurantId(ImpeachBean impeachBean);

	List<ImpeachBean> select();

}