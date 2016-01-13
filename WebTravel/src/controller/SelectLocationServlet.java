package controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import model.bean.SceneBean;
import model.service.MemberService;
import model.service.SceneService;
import model.util.TypeConveter;
import other.bean.FavoriteBean;

/**
 * Servlet implementation class SelectLocationServlet
 */
@WebServlet("/SelectLocationServlet")
public class SelectLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 接收資料
		SceneService sceneservice = new SceneService();
		MemberService ms = new MemberService();
		List<SceneBean> li = new ArrayList<SceneBean>();
		List<FavoriteBean> fb = new ArrayList<FavoriteBean>();
		String lo = request.getParameter("location");
					
		// 驗證資料
		if ( "北區".equals(lo) || "中區".equals(lo) ||"南區".equals(lo) ||"東區".equals(lo)) {
			li = sceneservice.getLocation(lo);
			//轉換圖片格式為base64
			fb = ms.selectFavoriteBean(li);
//			System.out.println(fb.get(0).getScenePhoto());
		}
		
		
		// 轉換資料
		//JSONArray scenelist = TypeConveter.parseJSONArray(li); 
		// model
		HttpSession session = request.getSession();
		session.setAttribute("li", fb);
		
//		PrintWriter out = response.getWriter();
//		out.print(scenelist);
		
		// View
//		RequestDispatcher rd = request.getRequestDispatcher("/scene/scene_location.jsp");
//		rd.forward(request, response);
		response.sendRedirect(request.getContextPath()+"/scene/scene_location.jsp");
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
