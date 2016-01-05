package model.service;

import java.util.List;

import model.bean.ThoughtBean;
import model.dao.ThoughtDAO;
import model.dao.jndi.ThoughtDAOjndi;

public class ThoughtService {
	ThoughtDAO thoughtDao = new ThoughtDAOjndi();
	ThoughtBean bean = new ThoughtBean();

	public List<ThoughtBean> getThoughttype(String thoughtType) {
		if ("綜合".equals(thoughtType) || "景點".equals(thoughtType)
				|| "餐廳".equals(thoughtType)) {
			return (List<ThoughtBean>) thoughtDao.select(thoughtType);
		} else {
			return null;
		}
	}

}
