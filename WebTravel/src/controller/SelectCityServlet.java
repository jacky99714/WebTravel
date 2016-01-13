package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SceneBean;
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
		response.setContentType("text/html;charset=UTF-8");
		
		//接收資料
		String city = request.getParameter("city");
		SceneService sceneservice = new SceneService();
		List<SceneBean> listsb =  new ArrayList<>();
		List<FavoriteBean> listcity = new ArrayList<>();
		//驗證資料
		if("台北市".equals(city) || "新北市".equals(city) || "基隆市".equals(city) ||
		   "桃園市".equals(city) || "新竹縣".equals(city) || "宜蘭縣".equals(city) ||		
		   "苗栗縣".equals(city) || "台中市".equals(city) || "彰化縣".equals(city) ||
		   "南投縣".equals(city) || "雲林縣".equals(city) || "嘉義縣".equals(city) ||
		   "台南市".equals(city) || "高雄市".equals(city) || "屏東縣".equals(city) ||
		   "澎湖縣".equals(city) || "金門縣".equals(city) || "花蓮縣".equals(city) ||
		   "台東縣".equals(city)	
			){
			listsb = sceneservice.getCity(city);
			listcity =sceneservice.changeBean(listsb);
		}
		//轉換資料
		
		
		//model
		HttpSession session = request.getSession();
		session.setAttribute("listcity", listcity);
		
		//view
		response.sendRedirect(request.getContextPath()+"/scene/scene_city.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
