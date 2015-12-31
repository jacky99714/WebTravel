package controller;

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

import model.bean.SceneBean;
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
		response.setContentType("application/json; charset=UTF-8");

		// 接收資料
		SceneService sceneservice = new SceneService();
		List<FavoriteBean> li = new ArrayList<>();
		String lo = request.getParameter("location");
					
		// 驗證資料
		if ( lo.equals("北區") || lo.equals("中區") ||lo.equals("南區") ||lo.equals("東區")) {
			li = sceneservice.getLocation(lo);
		}
		// 轉換資料

		// model
		PrintWriter out = response.getWriter();
		out.print(TypeConveter.parseJSONArray(li));
		
		// model執行結果，View
//		RequestDispatcher rd = request.getRequestDispatcher("scene_location.jsp");
//		rd.forward(request, response);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
