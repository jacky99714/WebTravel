package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.bean.CollectBean;
import model.bean.MemberBean;
import model.bean.SceneBean;
import model.dao.jndi.CollectDAOjndi;
import model.dao.jndi.MemberDAOjndi;
import model.dao.jndi.SceneDAOjndi;
import model.util.TypeConveter;




public class MemberService {
	MemberDAOjndi mDAO= new MemberDAOjndi();
	CollectDAOjndi cDAO = new CollectDAOjndi();
	SceneDAOjndi sDAO = new SceneDAOjndi();
	HashMap<String, String> error = new HashMap<String,String>();
	//登入使用
	public MemberBean login(String useid,String password){
		MemberBean mb=  mDAO.select(useid);
		if (mb!=null) {
			if (password != null && password.length() != 0) {
				if(mb.getPassword().equals(password)){
					return mb;
				}
			} 
		}
		return null;
	}
	//增加會員
	public MemberBean insert(MemberBean memberBean){
		if(memberBean!=null){
				String p= TypeConveter.EncodeBase64(memberBean.getPassword().getBytes());
				memberBean.setPassword(p);
			 MemberBean mb=mDAO.insert(memberBean);
			 return mb;
		}
		return null;
	}
	//抓到會員收藏
	public List<SceneBean> getMemberCollectScene(int memberId){
		List<CollectBean> cbList = cDAO.select(memberId);
		List<SceneBean> sbList = new ArrayList<SceneBean>();
		for(CollectBean c: cbList){
			sbList.add(sDAO.select(c.getSceneId()));
		}
		return sbList;
	}
	//刪除會員的收藏
	public boolean isDeleteMbCollect(int memberId,int sceneId){
		return cDAO.delete(memberId, sceneId);
	}
	//叫出景點
	public SceneBean selectSceneId(int sceneId){
		return sDAO.select(sceneId);
	}
	
	
}
