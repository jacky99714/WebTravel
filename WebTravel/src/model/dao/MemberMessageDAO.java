package model.dao;

import java.util.List;

import model.bean.MemberMessageBean;

public interface MemberMessageDAO {

	List<MemberMessageBean> select();

	List<MemberMessageBean> selectMemberId(int memberId);

	MemberMessageBean select(int memberMessageId);

	List<MemberMessageBean> insert(MemberMessageBean memberMessageBean);

	List<MemberMessageBean> update(MemberMessageBean memberMessageBean);

	boolean delete(int memberMessageID);

}