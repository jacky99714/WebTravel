package jacky.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MemberBean;
import model.bean.ScheduleBean;
import model.service.MemberService;

@WebServlet("/MyScheduleServlet")
public class MyScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyScheduleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    MemberService ms = new MemberService();
	    HttpSession session = request.getSession();
	    MemberBean memberBean = (MemberBean)session.getAttribute("loginOk");
	    List<ScheduleBean> listSchedule= ms.select(memberBean.getMemberId());
	    session.setAttribute("listSchedule", listSchedule);
	    response.sendRedirect(request.getContextPath()+"/JMember/MySchedule.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
