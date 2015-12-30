package controller.jack;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.MemberBean;
import model.service.MemberService;


@WebServlet("/JoinMemberServlet")
public class JoinMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinMemberServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		//接收
		String temp1 = request.getParameter("useid");
		String temp2 = request.getParameter("password");
		String temp3 = request.getParameter("lastname");
		String temp4 = request.getParameter("firstname");
		String temp5 = request.getParameter("nickname");
		String temp6 = request.getParameter("birthday");
		String temp7 = request.getParameter("cphone");
		String temp8 = request.getParameter("hphone");
		String temp9 = request.getParameter("email");
		String temp10 = request.getParameter("addr");
//		String temp11 = request.getParameter("photo");
		
//-----------------------------------------------------------
		Collection<Part> parts = request.getParts();
		Part pho =request.getPart("photo"); 
		InputStream in =pho.getInputStream();
		byte[] phto =new byte[(int)pho.getSize()];
		in.read(phto);
//		OutputStream ou = new FileOutputStream("C:/Users/Student/Desktop/04.jpg");
//		ou.write(phto);
//		ou.close();
		in.close();
		String s = Base64.getEncoder().encodeToString(phto);
		
//-----------------------------------------------------------
		//驗證
		Map<String, String> error =new HashMap<String,String>();
		request.setAttribute("errorMap",error);
		
		if(temp1==null || temp1.length()==0){
			error.put("useid", "請輸入帳號");
		}
		if(temp2==null || temp2.length()==0){
			error.put("password", "請輸入密碼");
		}
		if(temp3==null || temp3.length()==0){
			error.put("lastname", "請輸入姓氏");
		}
		if(temp3==null || temp3.length()==0){
			error.put("firstname", "請輸入名字");
		}
		java.util.Date date = null;
		if(temp6==null || temp6.length()==0){
			error.put("birthday", "請輸入生日");
		}else{
			date = MemberBean.converDate(temp6);
			System.out.println("JoinMemberServlet:"+date);
		}
		if(temp7==null || temp7.length()==0){
			error.put("cphone", "請輸入手機電話");
		}
		if(temp9==null || temp9.length()==0){
			error.put("email", "請輸入電子郵件");
		}
		if(error!=null && !error.isEmpty()){
			request.getRequestDispatcher("/secure/joinMember.jsp").forward(request, response);
		}
		
		//model
		MemberService ms = new MemberService();
		MemberBean mb = new MemberBean();
		
		mb.setUserName(temp1);
		mb.setPassword(temp2);
		mb.setLastName(temp3);
		mb.setFirstName(temp4);
		mb.setNickName(temp5);
		mb.setBirthDay(date);
		mb.setCellphone(temp7);
		mb.setTelephone(temp8);
		mb.setEmail(temp9);
		mb.setAddress(temp10);
		mb.setPhoto(phto);
		
		MemberBean rsbean = ms.insert(mb);
		//view
		if(rsbean!=null){
			if(rsbean.getPhoto()!=null){
				String phtoB64 =model.util.TypeConveter.EncodeBase64(rsbean.getPhoto());
				session.setAttribute("phtoB64", phtoB64);
			}
			session.setAttribute("member", rsbean);
			response.sendRedirect(request.getContextPath()+"/secure/joinSuccess.jsp");
		}else{
			request.getRequestDispatcher("/secure/joinMember.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
