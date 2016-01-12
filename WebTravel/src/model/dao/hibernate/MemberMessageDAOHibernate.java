package model.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import model.bean.MemberMessageBean;
import model.dao.MemberMessageDAO;
import model.hibernate.HibernateUtil;

public class MemberMessageDAOHibernate implements MemberMessageDAO{
	private Session session;
	public MemberMessageDAOHibernate(Session session) {
		super();
		this.session=session;
	}
	public Session getSession() {
		return session;
	}
	@Override
	public List<MemberMessageBean> select() {
		
		return (List<MemberMessageBean>)getSession().createQuery("from MemberMessageBean").list();
	}
	public static void main(String[] args) {
		
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			MemberMessageDAOHibernate mmDAO =new MemberMessageDAOHibernate(session);
			
			//select 
//			System.out.println(mmDAO.select());
//			System.out.println(mmDAO.selectMemberId(1));
//			System.out.println(mmDAO.select(1));
			
			//insert
			
			
			//delete

			
			session.getTransaction().commit();
		} finally{
			HibernateUtil.closeSessionFactory();
		}
	}
	
	@Override
	public List<MemberMessageBean> selectMemberId(int memberId) {
		
		return (List<MemberMessageBean>)getSession().createQuery("from MemberMessageBean where memberId='"+memberId+"'").list();
	}

	@Override
	public MemberMessageBean select(int memberMessageId) {
		return (MemberMessageBean)getSession().get(MemberMessageBean.class, memberMessageId);
	}

	@Override
	public List<MemberMessageBean> insert(MemberMessageBean memberMessageBean) {
		return null;
	}

	@Override
	public List<MemberMessageBean> update(MemberMessageBean memberMessageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(int memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(int memberMessageID) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
