package model.dao;

import java.util.List;

import model.bean.ThoughtBean;

public interface ThoughtDAO {

	List<ThoughtBean> select();

	List<ThoughtBean> select(String thoughtName);
	
	ThoughtBean select(int thoughtId);

	ThoughtBean update(ThoughtBean thoughtBean);

	ThoughtBean insert(ThoughtBean thoughtBean);

	boolean delete(int thoughtId);

}