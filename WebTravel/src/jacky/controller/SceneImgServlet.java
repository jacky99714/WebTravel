package jacky.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.MemberBean;
import model.bean.SceneBean;
import model.dao.hibernate.SceneDAOHibernate;
import model.service.MemberService;

@WebServlet("/SceneImgServletq")
public class SceneImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SceneImgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("image/gif; charset=UTF-8");
	    String sceneName = request.getParameter("sceneName");
	    MemberService ms = new MemberService();
	    ServletOutputStream out = response.getOutputStream();
	    if(sceneName!=null){
	    	SceneBean scene =ms.selectScene(sceneName);
	    	byte[] photo = scene.getScenePhoto();
	    	if(photo!=null){
	    		out.write(photo);
	    	}
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
