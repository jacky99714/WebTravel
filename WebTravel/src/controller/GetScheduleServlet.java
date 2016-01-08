package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.service.PlanService;
import model.util.TypeConveter;
import other.bean.FavoriteBean;

/**
 * Servlet implementation class PlanServlet
 */
@WebServlet("/plan/GetScheduleServlet")
public class GetScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		List<Integer> li =  (List<Integer>)session.getAttribute("schedule");
		if(li != null){
			System.out.println("liGetScheduleServlet");
			System.out.println("li= "+li);
			PlanService ps = new PlanService(); 
			List<FavoriteBean> fav = ps.getSchedule(li);
			System.out.println("li= "+fav);	
			out.print(TypeConveter.parseJSONArray(fav));
		}else{
			li = new ArrayList<Integer>();
			out.print(TypeConveter.parseJSONArray(li));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
