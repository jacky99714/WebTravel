package model.service;

import java.util.HashMap;

import model.bean.MemberBean;
import model.dao.jndi.MemberDAOjndi;
import model.util.TypeConveter;

public class MemberService {
	MemberDAOjndi mDAO= new MemberDAOjndi();
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
	public static String convertJacky(byte[] src){
		return TypeConveter.base64Convert(src);
	}
	
	
	
	
	//增加會員
	public MemberBean insert(MemberBean memberBean){
		if(memberBean!=null){
			 MemberBean mb=mDAO.insert(memberBean);
			 return mb;
		}
		
		
		return null;
				
	}
}
