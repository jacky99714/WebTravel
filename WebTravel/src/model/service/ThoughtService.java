package model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.bean.ThoughtBean;
import model.dao.ThoughtDAO;
import model.dao.hibernate.ThoughtDAOHibernate;
import model.dao.jndi.ThoughtDAOjndi;
import model.hibernate.HibernateUtil;
import model.util.TypeConveter;
import other.bean.MythoughtBean;

public class ThoughtService {
//	ThoughtDAO thoughtDao = new ThoughtDAOjndi();
	private ThoughtDAO thoughtDao;
	
	public ThoughtService(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		thoughtDao = new ThoughtDAOHibernate(session);
	}
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
	
	public List<MythoughtBean> getAllThought(){
		List<ThoughtBean> listTB = thoughtDao.select();
		List<MythoughtBean> listMB = new ArrayList<>();
		for(ThoughtBean bean :listTB){
//			bean.getMember().getNickName();
			listMB.add(TypeConveter.pareseMythoughtBean(bean));
		}
		return listMB;
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
