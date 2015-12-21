package model.service;

import java.util.HashMap;

import model.MemberBean;
import model.dao.jndi.MemberDAOjndi;
import org.apache.tomcat.util.codec.binary.Base64;
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
		return Base64.encodeBase64URLSafeString(src);
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
