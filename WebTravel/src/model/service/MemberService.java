package model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import model.bean.CollectBean;
import model.bean.MemberBean;
import model.bean.SceneBean;
import model.bean.ScheduleBean;
import model.bean.ScheduleContentBean;
import model.dao.CollectDAO;
import model.dao.MemberDAO;
import model.dao.SceneDAO;
import model.dao.ScheduleContentDAO;
import model.dao.ScheduleDAO;
import model.dao.hibernate.CollectDAOHibernate;
import model.dao.hibernate.MemberDAOHibernate;
import model.dao.hibernate.SceneDAOHibernate;
import model.dao.hibernate.ScheduleContentDAOHibernate;
import model.dao.hibernate.ScheduleDAOHibernate;
import model.dao.jndi.CollectDAOjndi;
import model.dao.jndi.SceneDAOjndi;
import model.dao.jndi.ScheduleContentDAOjndi;
import model.dao.jndi.ScheduleDAOjndi;
import model.hibernate.HibernateUtil;
import model.util.TypeConveter;
import other.bean.FavoriteBean;

public class MemberService {
	private MemberDAO mDAO;
	private CollectDAO cDAO ;
	private ScheduleDAO scheduleDAO ;
	private ScheduleContentDAO scheduleContentDAO ;
	private SceneDAO sDAO;
	public MemberService(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		mDAO =  new MemberDAOHibernate(session);
		cDAO = new CollectDAOHibernate(session);
		scheduleDAO =new ScheduleDAOHibernate(session);
		scheduleContentDAO = new ScheduleContentDAOHibernate(session);
		sDAO = new SceneDAOHibernate(session);
	}
	
	
	HashMap<String, String> error = new HashMap<String,String>();
	//登入使用
	public MemberBean login(String useid,String password){
		MemberBean mb=  mDAO.select(useid);
		if (mb!=null) {
			if (password != null && password.length() != 0) {
				if(new String(mb.getPassword()).equals(password)){
					return mb;
				}
			} 
		}
		return null;
	}
	//增加會員
	public MemberBean insert(MemberBean memberBean) throws FileNotFoundException{
		if(memberBean!=null){
//				String p= TypeConveter.EncodeBase64(memberBean.getPassword().getBytes());
//				memberBean.setPassword(p);
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
	//修改會員資料
	public MemberBean updateContext(MemberBean memberBean) throws IOException{
		if(memberBean!=null){
			System.out.println("MemberSevice:updata");
			return mDAO.update(memberBean);
		}
		return null;
	}
	//修改資料
	public MemberBean updata(MemberBean memberBean) throws IOException{
		if(memberBean!=null){
			return mDAO.update(memberBean);
		}
		return null;
	}
	//找出行程名稱
	public List<ScheduleBean> select(int MemberId){
		return scheduleDAO.selectMember(MemberId) ;
	}
	//找出行程內容
	public List<ScheduleContentBean> selectScheduleContentBean(int ScheduleContentId) {
		return scheduleContentDAO.selectSchedule(ScheduleContentId);
	}
	//用行程內容找出個人行程的景點
	public List<SceneBean> selectSceneBean(List<ScheduleContentBean> listSCB){
		List<SceneBean> list = new ArrayList<SceneBean>();
		for(ScheduleContentBean s :listSCB){
			list.add(sDAO.select(s.getSceneId()));
		}
		return list;	
	}
	//轉成另一個景點BEAN 圖片是String格式
	public List<FavoriteBean> selectFavoriteBean(List<SceneBean> list){
		List<FavoriteBean> listFB = new ArrayList<FavoriteBean>();
		for(SceneBean s : list){
			FavoriteBean fb = new FavoriteBean();
			fb.setCity(s.getCity());
			fb.setLocation(s.getLocation());
			fb.setMemberId(s.getMemberId());
			fb.setSceneContent(s.getSceneContent());
			fb.setSceneId(s.getSceneId());
			fb.setSceneName(s.getSceneName());
			fb.setScenePhoto(TypeConveter.EncodeBase64(s.getScenePhoto()));
			fb.setTimeEnd(s.getTimeEnd());
			fb.setTimeStart(s.getTimeStart());
			listFB.add(fb);
		}
		return listFB;
	}
	//刪除該行程的內容
	public boolean deletescheduleContent(int scheduleId){
		return scheduleContentDAO.delete(scheduleId);
	}
	//新增行程內容
	public boolean insertScheduleContent(ScheduleContentBean bean){
		return scheduleContentDAO.insert(bean);
	}
	
	//將景點內容顯示字數少一點
	public List<SceneBean> SubStirngCount(List<SceneBean> list){
		for(SceneBean s :list){
			if(s.getSceneContent().length()>70){
				s.setSceneContent(s.getSceneContent().substring(0,70)+"...");
			}
		}
		return list;
	}
	
	
}
