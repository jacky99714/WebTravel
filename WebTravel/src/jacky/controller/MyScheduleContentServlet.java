package jacky.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;



import model.bean.SceneBean;
import model.bean.ScheduleContentBean;
import model.service.MemberService;
import other.bean.FavoriteBean;

@WebServlet("/MyScheduleContentServlet")
public class MyScheduleContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyScheduleContentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			List<String> list = new ArrayList<String>();
			list.clear();
			JSONArray jsonArray;
			HttpSession session = request.getSession();
			response.setContentType("application/json; charset=UTF-8");
			MemberService ms = new MemberService();
			PrintWriter out = response.getWriter();
			String scheduleId = request.getParameter("Schedule");
			session.setAttribute("ScheduleId", scheduleId);
//			System.out.println("MyScheduleContentServlet:"+scheduleId);
			List<ScheduleContentBean> listSCB = ms.selectScheduleContentBean(new Integer(scheduleId));
//			System.out.println("MyScheduleContentServlet:"+listSCB);
			List<SceneBean> listSB = ms.selectSceneBean(listSCB);
//			System.out.println("MyScheduleContentServlet:"+listSB);
			List<FavoriteBean> listFB =ms.selectFavoriteBean(listSB);
			jsonArray = new JSONArray(listFB);
			out.println(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
