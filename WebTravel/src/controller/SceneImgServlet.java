package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SceneImgBean;
import model.service.SceneImgService;
import other.bean.SceneImg;

/**
 * Servlet implementation class SceneImgServlet
 */
@WebServlet("/SceneImgServlet")
public class SceneImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String sid = request.getParameter("sceneId");
		int isid = Integer.valueOf(sid);
		
		SceneImgService sis = new SceneImgService();
		List<SceneImgBean> rs = sis.selectImg(isid);
		List<SceneImg> rs64 = sis.change64(rs);
		HttpSession session = request.getSession();
		session.setAttribute("listimg", rs64);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
