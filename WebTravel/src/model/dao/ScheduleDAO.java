package model.dao;

import java.util.List;

import model.bean.ScheduleBean;

public interface ScheduleDAO {

	//查詢
	ScheduleBean select(int scheduleId);

	List<ScheduleBean> select();

	boolean insert(ScheduleBean scheduleBean);

	ScheduleBean update(ScheduleBean scheduleBean);

	boolean delete(int scheduleId);

	int getInsertId(ScheduleBean scheduleBean);

}