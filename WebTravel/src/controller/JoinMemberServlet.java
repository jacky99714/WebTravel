package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;

@WebServlet("/JoinMemberServlet")
public class JoinMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinMemberServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String temp11 = request.getParameter("photo");
		//驗證
		MemberBean mb = new MemberBean();
		mb.setUserName(temp1);
		mb.setPassword(temp2);
		mb.setLastName(temp3);
		mb.setFirstName(temp4);
		mb.setNickName(temp5);
		//model
		//view
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
