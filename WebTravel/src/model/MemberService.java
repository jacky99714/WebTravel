package model;



import model.dao.jndi.MemberDAOjndi;

public class MemberService {
	
	public MemberBean login(String useid,String password){
		MemberDAOjndi mDAO= new MemberDAOjndi();
		MemberBean mb=  mDAO.select(useid);
//		System.out.println(mb+":"+"service");
		if (mb!=null) {
			if (password != null && password.length() != 0) {
				if(mb.getPassword().equals(password)){
					return mb;
				}
			} 
		}
		
		return null;
	}
}
