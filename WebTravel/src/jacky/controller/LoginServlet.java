package jacky.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MemberBean;
import model.service.MemberService;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getContextPath();  /WebTravel
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		HttpSession session =request.getSession();
		session.removeAttribute("memberimg");
		Map<String, String> error = new HashMap<String,String>();
		request.setAttribute("error",error);
		//接收資料--------------------------------------------
		String temp1 = request.getParameter("useid");
		String temp2 = request.getParameter("password");
		
//		System.out.println(temp1+":"+temp2);
		
		//驗證資料--------------------------------------------
		if(temp1==null||temp1.length()==0){
			error.put("useid", "請輸入帳號");
		}
		if(temp2==null||temp2.length()==0){
			error.put("password", "請輸入密碼");
		}
		if(error!=null && !error.isEmpty()){

			request.getRequestDispatcher(
					"/secure/login.jsp").forward(request, response);
		}else{
			//呼叫Model------------------------------------------
			MemberService ms = new MemberService();
			
			//根據Model執行結果，呼叫View-----------------------------
			if(ms.login(temp1, temp2)==null){
				request.getRequestDispatcher(
						"/secure/login.jsp").forward(request, response);
			}else{
				MemberBean mb =ms.login(temp1, temp2);
				if(mb.getPhoto()!=null){
					String s = model.util.TypeConveter.EncodeBase64(mb.getPhoto());
					session.setAttribute("memberimg",s);
				}
//			System.out.println("LoginServlet:"+s);
				session.setAttribute("loginOk", mb);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
