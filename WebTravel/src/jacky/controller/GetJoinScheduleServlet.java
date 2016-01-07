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

@WebServlet("/GetJoinScheduleServlet")
public class GetJoinScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetJoinScheduleServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		JSONArray jsonArray;
		HttpSession session = request.getSession();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		List<SceneBean> scheduleList=(ArrayList<SceneBean>)session.getAttribute("scheduleList");
		jsonArray = new JSONArray(scheduleList);
//		System.out.println("GetJoinScheduleServlet:"+jsonArray);
		out.print(jsonArray);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
