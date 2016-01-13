package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SceneMessageBean;
import model.service.SceneMessageService;

/**
 * Servlet implementation class SceneGetMessageServlet
 */
@WebServlet("/SceneGetMessageServlet")
public class SceneGetMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("sceneId");
		
		SceneMessageService scenemessage = new SceneMessageService();
		List<SceneMessageBean> listmessage = scenemessage.selectmessage(Integer.valueOf(sid));
		HttpSession session = request.getSession();
		session.setAttribute("listmessage", listmessage);
		System.out.println(listmessage);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
