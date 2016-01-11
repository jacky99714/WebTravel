package jacky.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import model.bean.MemberBean;
import model.bean.ScheduleContentBean;
import model.service.MemberService;


@WebServlet("/UpdataScheduleContentServlet")
public class UpdataScheduleContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdataScheduleContentServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
//		JSONObject jsonObject = new JSONObject(request.getParameter("a"));
		JSONArray jsonArray = new JSONArray(request.getParameter("a"));
//		System.out.println("UpdataScheduleContentServlet:"+jsonArray);
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean)session.getAttribute("loginOk");
		String scheduleId = (String)session.getAttribute("ScheduleId");
//		System.out.println("UpdataScheduleContentServlet:"+scheduleId);
		
		
		
		MemberService ms = new MemberService();
		if(mb!=null){
			ms.deletescheduleContent(new Integer(scheduleId));
			int a = 1;
			for(Object s :jsonArray){
				int i =new Integer(s.toString());
				ScheduleContentBean bean = new ScheduleContentBean();
				bean.setSceneId(i);
				bean.setScheduleOrder(a);
				a++;
				bean.setScheduleId(new Integer(scheduleId));
				ms.insertScheduleContent(bean);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
