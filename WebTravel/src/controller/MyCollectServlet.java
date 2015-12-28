package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MemberBean;
import model.bean.SceneBean;
import model.service.MemberService;

@WebServlet("/MyCollectServlet")
public class MyCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberService memberService = new MemberService();
    
    public MyCollectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		MemberBean mb = (MemberBean)session.getAttribute("loginOk");
		SceneBean sb = new SceneBean();
//		System.out.println("MyCollectServlet:"+mb);
		if(mb!=null){
			List<SceneBean> sceneList = memberService.getMemberCollectScene(mb.getMemberId());
//			System.out.println("MyCollectServlet:"+sceneList);
			session.setAttribute("sceneList", sceneList);
		}
		response.sendRedirect(request.getContextPath()+"/JMember/MyCollect.jsp");
//		request.getRequestDispatcher("/JMember/MyCollect.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
