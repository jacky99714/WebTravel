package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.SceneService;
import other.bean.FavoriteBean;

/**
 * Servlet implementation class SelectCityServlet
 */
@WebServlet("/SelectCityServlet")
public class SelectCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		//接收資料
		
		//驗證資料
		
		//轉換資料
		
		//model
		SceneService sceneservice = new SceneService();
		List<FavoriteBean> li = new ArrayList<>();
		li = sceneservice.getCity(request.getParameter("city"));
		
		//view
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
