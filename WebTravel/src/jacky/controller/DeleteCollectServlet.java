package jacky.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/DeleteCollectServlet")
public class DeleteCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCollectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    	
	    
		HttpSession session = request.getSession();
		MemberService memberService = new MemberService();
		String scene = request.getParameter("scene");
//		System.out.println(scene);
		MemberBean memberBean =(MemberBean)session.getAttribute("loginOk");
		boolean b =memberService.isDeleteMbCollect(memberBean.getMemberId(), new Integer(scene));
		PrintWriter out = response.getWriter();
		if(b){
			List<SceneBean> sceneList = memberService.getMemberCollectScene(memberBean.getMemberId());
			session.setAttribute("sceneList", sceneList);
			out.write("true");
		}else{
			out.write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
