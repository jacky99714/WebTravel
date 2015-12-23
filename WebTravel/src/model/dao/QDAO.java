package model.dao;

import java.util.List;

import model.bean.QBean;

public interface QDAO {

	List<QBean> select();

	QBean select(int qId);

	QBean select(String qName);

	boolean delete(int qId);

	QBean insert(QBean qBean);

	QBean update(QBean qBean);


	int getCount();

}