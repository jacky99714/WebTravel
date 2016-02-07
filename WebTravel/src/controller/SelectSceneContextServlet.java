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
import model.bean.SceneImgBean;
import model.bean.SceneMessageBean;
import model.service.SceneImgService;
import model.service.SceneMessageService;
import model.service.SceneService;
import other.bean.FavoriteBean;
import other.bean.SceneImg;

/**
 * Servlet implementation class SelectSceneContextServlet
 */
@WebServlet("/SelectSceneContextServlet")
public class SelectSceneContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//接收資料
		String sname = request.getParameter("sceneName");
		//驗證資料
		
		//轉換資料
		
		//model
		SceneBean nbean = new SceneBean();
		SceneService sceneservice = new SceneService();
		SceneMessageService scenemessage = new SceneMessageService();
		SceneImgService imgservice = new SceneImgService();
		nbean = sceneservice.getName(sname);//找出景點內容
		int sid = nbean.getSceneId();
		List<SceneImgBean> sceneimg = imgservice.selectImg(sid);
		List<SceneImg> sceneimg64 = imgservice.change64(sceneimg);
		
		List<SceneMessageBean> listmessage = scenemessage.selectmessage(nbean.getSceneId());//找出留言內容
		
		
			//System.out.println("jiontest:"+listmessage.get(0).getMenberBean());
		
			HttpSession session = request.getSession();
			session.removeAttribute("listmessage");
			session.removeAttribute("namebean");
			session.setAttribute("listmessage", listmessage);		
			session.setAttribute("namebean", nbean);
			session.setAttribute("listimg", sceneimg64);
				
		//view
		
		response.sendRedirect(request.getContextPath()+"/scene/scene_content.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
