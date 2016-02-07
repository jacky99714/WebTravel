package jacky.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MemberBean;
import model.bean.SceneBean;
import model.bean.ScheduleBean;
import model.service.MemberService;

@WebServlet("/DeleteScheduleServlet")
public class DeleteScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteScheduleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    	
	    
		HttpSession session = request.getSession();
		MemberService memberService = new MemberService();
		String scheduleId = request.getParameter("schedule");
//		System.out.println(scheduleId);
		MemberBean memberBean =(MemberBean)session.getAttribute("loginOk");
		PrintWriter out = response.getWriter();
		
		if(scheduleId!=null){
			boolean b =memberService.deleteSchedule(Integer.parseInt(scheduleId));
			if(b){
				out.print("成功");
			    List<ScheduleBean> listSchedule= memberService.select(memberBean.getMemberId());
			    session.setAttribute("listSchedule", listSchedule);
			}else{
				out.print("失敗");
			}
		}else{
			out.print("失敗");
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
