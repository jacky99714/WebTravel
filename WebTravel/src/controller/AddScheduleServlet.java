package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class setScheduleServlet
 */
@WebServlet("/plan/AddScheduleServlet")
public class AddScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();
		try{
			int sceneId = Integer.parseInt(request.getParameter("sceneId"));
			boolean insert = false;
			List<Integer> li = new LinkedList<>();
			HttpSession session = request.getSession();

			if(session.getAttribute("schedule") == null){	
				li.add(sceneId);
				session.setAttribute("schedule",li);
			}else{
	
				li = (List<Integer>)session.getAttribute("schedule");
				for(int key: li){
					if(key == sceneId){
						insert = true;   //session 有相同景點
						break;
					}
				}
				if(!insert){
					li.add(sceneId);
				}			
			}
			out.print(insert);
		}catch(NumberFormatException e){
			System.out.println(request.getParameter("sceneId"));
			System.out.println("it is not a number");
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
