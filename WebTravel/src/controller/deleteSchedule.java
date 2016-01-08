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

import model.bean.SceneBean;
import model.util.TypeConveter;

/**
 * Servlet implementation class deleteSchedule
 */
@WebServlet("/plan/deleteSchedule")
public class deleteSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try{
			int delete= Integer.parseInt(request.getParameter("deleteId"));
			System.out.println("delete "+delete);
			HttpSession session = request.getSession();
			List<SceneBean> scheduleList =  (List<SceneBean>)session.getAttribute("scheduleList");
			List<Integer> li =  (List<Integer>)session.getAttribute("schedule");
			if(scheduleList != null){
				for(SceneBean bean:scheduleList){
					if(bean.getSceneId() == delete){
						scheduleList.remove(bean); 
					}
				}				
			}

			if(li != null){
				for(int i=0; i< li.size();i++){
					if(li.get(i) == delete){
						li.remove(i);
						break;
					}
				}				
			}

			
		}catch(NumberFormatException e){
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
