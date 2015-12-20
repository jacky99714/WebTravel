package model.dao;

import java.util.List;

import model.ScheduleContentBean;

public interface ScheduleContentDAO {

	List<ScheduleContentBean> select();

	ScheduleContentBean select(int scheduleContentId);

	boolean insert(ScheduleContentBean scheduleContentBean);

	boolean delete(int scheduleContentId);

	ScheduleContentBean update(ScheduleContentBean scheduleContentBean);

}