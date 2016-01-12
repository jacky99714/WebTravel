package jacky.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MemberBean;
import model.bean.SceneBean;
import model.service.MemberService;
import other.bean.FavoriteBean;

@WebServlet("/MyCollectServlet")
public class MyCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    public MyCollectServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    String s= request.getParameter("start");
	    String e= request.getParameter("end");
	    System.out.println(s+":"+e);
		HttpSession session =request.getSession();
		MemberBean mb = (MemberBean)session.getAttribute("loginOk");
		SceneBean sb = new SceneBean();
//		System.out.println("MyCollectServlet:"+mb);
		if(mb!=null){
			MemberService memberService = new MemberService();
			List<SceneBean> sceneList = memberService.getMemberCollectScene(mb.getMemberId());
			sceneList=memberService.SubStirngCount(sceneList);
			List<FavoriteBean> sceneListF=memberService.selectFavoriteBean(sceneList);
//			System.out.println("MyCollectServlet:"+sceneList);
			session.removeAttribute("sceneList");
			session.setAttribute("sceneList", sceneListF);
			//分頁顯示
			
			if (e==null&&s==null) {
				int rowCount = sceneListF.size(); //list count 
				System.out.println(rowCount);
				int pageSize = 4;//-1  一頁幾筆資料
				int pageq = rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
				int start = 0;
				int end = pageSize;
				session.setAttribute("rowCount", rowCount);
				session.setAttribute("pageSize", pageSize);
				session.setAttribute("pageq", pageq);
				session.setAttribute("start", start);
				session.setAttribute("end", end);
			}else{
				session.setAttribute("start", Integer.parseInt(s));
				session.setAttribute("end", Integer.parseInt(e));
				
			}
			
			//分頁結束
			
		}
		
		
		response.sendRedirect(request.getContextPath()+"/JMember/MyCollect2.jsp");
//		request.getRequestDispatcher("/JMember/MyCollect.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
