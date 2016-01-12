package model.dao.hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;

import model.bean.MemberBean;
import model.dao.MemberDAO;
import model.hibernate.HibernateUtil;

public class MemberDAOHibernate implements MemberDAO{

	private Session session;
	
	public MemberDAOHibernate(Session session) {
		super();
		this.session = session;
	}
	
	private Session getSession(){
		return session;
	}
	
	public static void main(String[] args) throws IOException, ParseException{
		
		
		File f = new File("C:/Users/Student/Desktop/Member2.jpg");
		byte[] poto = new byte[(int)f.length()];
		FileInputStream fi = new FileInputStream(f);
		fi.read(poto);
		fi.close();
		
//--------------------------假資料--------------------------------
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		MemberBean mbean = new MemberBean();
		mbean.setMemberId(30);
		mbean.setUserName("j1ttdddtt");
		mbean.setPassword("B".getBytes());
		mbean.setFirstName("ddddh");
		mbean.setLastName("dddddy");
		mbean.setNickName("moddddduse");
		mbean.setBirthDay(sdf.parse("1991-11-22"));
		mbean.setAddress("台北市");
		mbean.setCellphone("0919929sss9393");
		mbean.setTelephone("02222sss22222");
		mbean.setEmail("jsuusssssse@gmail.com");
		mbean.setPhoto(poto);
		
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			MemberDAOHibernate mDAO = new MemberDAOHibernate(session);
			
			//select
//			List<MemberBean> mb =mDAO.select();
//			System.out.println(mb);
			
			//select name
//			System.out.println(mDAO.select("jack1"));
			
			//insert
//			System.out.println(mDAO.insert(mbean));
			
			//updata
			System.out.println(mDAO.updateContext(mbean));
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	
	@Override
	public List<MemberBean> select() {
		return getSession().createQuery("FROM MemberBean").list();
	}

	@Override
	public MemberBean select(int memberId) {
		return (MemberBean)getSession().load(MemberBean.class,memberId);
	}

	@Override
	public MemberBean select(String userName) {
		return (MemberBean)getSession().createQuery("from MemberBean where userName='"+userName+"'").uniqueResult();
	} 

	@Override
	public MemberBean insert(MemberBean memberBean) throws FileNotFoundException {
		return (MemberBean)getSession().get(MemberBean.class,getSession().save(memberBean));
	}

	@Override
	public MemberBean update(MemberBean memberBean) throws IOException {
		MemberBean mb =select(memberBean.getMemberId());
		if (memberBean.getAddress()!=null) {
			mb.setAddress(memberBean.getAddress());
		}
		if (memberBean.getUserName()!=null) {
		mb.setUserName(memberBean.getUserName());
		}
		if (memberBean.getBirthDay()!=null) {
			mb.setBirthDay(memberBean.getBirthDay());//
		}
		if (memberBean.getCellphone()!=null) {
			mb.setCellphone(memberBean.getCellphone());//
		}
		if (memberBean.getEmail()!=null) {
			mb.setEmail(memberBean.getEmail());//
		}
		if (memberBean.getFirstName()!=null) {
			mb.setFirstName(memberBean.getFirstName());
		}
		if (memberBean.getLastName()!=null) {
			mb.setLastName(memberBean.getLastName());//
		}
		if (memberBean.getNickName()!=null) {
			mb.setNickName(memberBean.getNickName());
		}
		if (memberBean.getPassword()!=null) {
			mb.setPassword(memberBean.getPassword());
		}
		if (memberBean.getPhoto()!=null) {
			mb.setPhoto(memberBean.getPhoto());
		}
		if (memberBean.getTelephone()!=null) {
			mb.setTelephone(memberBean.getTelephone());
		}
		return mb;
	}

	@Override
	public boolean delete(String userName) {
		return false;
	}

	@Override
	public MemberBean updateContext(MemberBean memberBean) {
		
		if(memberBean!=null){
			MemberBean mb =select(memberBean.getMemberId());
			if (memberBean.getAddress()!=null) {
				mb.setAddress(memberBean.getAddress());
			}
			if (memberBean.getUserName()!=null) {
			mb.setUserName(memberBean.getUserName());
			}
			if (memberBean.getBirthDay()!=null) {
				mb.setBirthDay(memberBean.getBirthDay());//
			}
			if (memberBean.getCellphone()!=null) {
				mb.setCellphone(memberBean.getCellphone());//
			}
			if (memberBean.getEmail()!=null) {
				mb.setEmail(memberBean.getEmail());//
			}
			if (memberBean.getFirstName()!=null) {
				mb.setFirstName(memberBean.getFirstName());
			}
			if (memberBean.getLastName()!=null) {
				mb.setLastName(memberBean.getLastName());//
			}
			if (memberBean.getNickName()!=null) {
				mb.setNickName(memberBean.getNickName());
			}
			if (memberBean.getPassword()!=null) {
				mb.setPassword(memberBean.getPassword());
			}
			if (memberBean.getPhoto()!=null) {
				mb.setPhoto(memberBean.getPhoto());
			}
			if (memberBean.getTelephone()!=null) {
				mb.setTelephone(memberBean.getTelephone());
			}
			return mb;
		}else{
			return null;
		}
	}
	
}
