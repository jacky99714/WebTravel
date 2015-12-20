package model.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.MemberBean;

public interface MemberDAO {

	//查詢
	List<MemberBean> select();

	MemberBean select(int memberId);

	MemberBean select(String userName);

	//新增
	MemberBean insert(MemberBean memberBean) throws FileNotFoundException;

	MemberBean update(MemberBean memberBean) throws IOException;

	boolean delete(String userName);

}