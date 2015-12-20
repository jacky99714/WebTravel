package model.dao;

import java.util.List;

import model.SceneGradeBean;

public interface SceneGradreDAO {

	List<SceneGradeBean> select();

	List<SceneGradeBean> select(int sceneId);

	List<SceneGradeBean> insert(SceneGradeBean sceneGradeBean);

	List<SceneGradeBean> update(SceneGradeBean sceneGradeBean);

	boolean delete(int memberId, int sceneId);

}