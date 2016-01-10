package model.service;

import java.util.List;

import model.bean.MemberBean;
import model.bean.ThoughtBean;
import model.dao.ThoughtDAO;
import model.dao.jndi.ThoughtDAOjndi;

public class ThoughtService {
	ThoughtDAO thoughtDao = new ThoughtDAOjndi();
	ThoughtBean bean = new ThoughtBean();

	public List<ThoughtBean> getThoughtName(String thoughtName) {
		if ("綜合".equals(thoughtName) || "景點".equals(thoughtName)
				|| "餐廳".equals(thoughtName)) {
			return (List<ThoughtBean>) thoughtDao.select(thoughtName);
		} else {
			return null;
		}
	}
	public ThoughtBean getThoughtId(int thoughtId){
			return thoughtDao.select(thoughtId);
	}
	
	public List<ThoughtBean> getAllThought(){
		return (List<ThoughtBean>)thoughtDao.select();
	}
	public ThoughtBean insert(ThoughtBean thoughtBean){
		if(thoughtBean!=null){
//				String p= TypeConveter.EncodeBase64(memberBean.getPassword().getBytes());
//				memberBean.setPassword(p);
			ThoughtBean tb=thoughtDao.insert(thoughtBean);
			 return tb;
		}
		return null;
	}

}
