package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.CollectBean;
import model.bean.MemberBean;
import model.service.AddFavoriteService;

/**
 * Servlet implementation class SceneAddFavoriteServlet
 */
@WebServlet("/SceneAddFavoriteServlet")
public class SceneAddFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 接收資料
		
		String sid = request.getParameter("sceneId");
				
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean)session.getAttribute("loginOk");
		int mid = mb.getMemberId();
		
		Integer cid = 1;
		// 驗證資料
		
			
		
			
			
		
		// 轉換資料
		int isid = Integer.valueOf(sid);
		// model
		CollectBean cBean = new CollectBean();
		cBean.setSceneId(isid);
		cBean.setMemberId(mid);
		cBean.setCollectId(cid);
		
		AddFavoriteService add = new AddFavoriteService();
		add.addFavorite(cBean);
		// view
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
