package controller.jack;

import java.io.IOException;
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
		HttpSession session =request.getSession();
		session.removeAttribute("memberimg");
		
		//接收資料--------------------------------------------
		String temp1 = request.getParameter("useid");
		String temp2 = request.getParameter("password");
		
//		System.out.println(temp1+":"+temp2);
		
		//驗證資料--------------------------------------------
		
		
		
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
