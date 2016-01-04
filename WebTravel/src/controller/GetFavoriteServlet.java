package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MemberBean;
import model.service.PlanService;
import other.bean.FavoriteBean;

/**
 * Servlet implementation class PlanServlet
 */
@WebServlet("/GetFavoriteServlet")
public class GetFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    PlanService ps = new PlanService();
		List<FavoriteBean> li = new ArrayList<>();
		HttpSession session = request.getSession();
		MemberBean bean = (MemberBean) session.getAttribute("loginOk");
		if(bean != null){
			li = ps.getFavorite(bean.getMemberId());
		}
		
		
		session.setAttribute("fav", li);

		RequestDispatcher dispatcher = request.getRequestDispatcher("plan.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
