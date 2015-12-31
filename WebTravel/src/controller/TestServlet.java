package controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.bean.SceneBean;
import model.service.PlanService;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("TTTTT");

		JSONArray jsonArr = new JSONArray(request.getParameter("json")); 
		PlanService ps = new PlanService();
		ps.insertSchedule(jsonArr);
//		for(int i = 0; i < jsonArr.length();i++){
//			System.out.println("param i"+i+"  "+jsonArr.getJSONObject(i));	
//			JSONObject jsonObj =  jsonArr.getJSONObject(i);
//			int scheduleOrder = jsonObj.getInt("scheduleOrder");
//			String scheduleName = jsonObj.getString("scheduleName");
//			int sceneId = jsonObj.getInt("sceneId");
//			int memberId = jsonObj.getInt("memberId");
//			System.out.println("scheduleOrder-->"+scheduleOrder);
//			System.out.println("scheduleName-->"+scheduleName);
//			System.out.println("sceneId-->"+sceneId);
//			System.out.println("memberId-->"+memberId);
//			System.out.println("-------------");
//			
//		}
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
