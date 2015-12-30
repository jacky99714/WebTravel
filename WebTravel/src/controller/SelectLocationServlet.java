package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		li = sceneservice.getLocation(request.getParameter("location"));
		PrintWriter out = response.getWriter();
		out.print(TypeConveter.parseJSONArray(li));
		// 驗證資料

		// 轉換資料

		// model

		// model執行結果，View
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
