package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SceneBean;
import model.util.TypeConveter;
import other.bean.FavoriteBean;

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
			if(delete == -1){
				session.removeAttribute("scheduleList");
				session.removeAttribute("scheduleListFB");
			}else{
				List<SceneBean> scheduleList =  (List<SceneBean>)session.getAttribute("scheduleList");
				List<FavoriteBean> li =  (List<FavoriteBean>)session.getAttribute("scheduleListFB");
				if(scheduleList != null){
				     for (Iterator it = scheduleList.iterator();it.hasNext();){    //reparations为Collection  
				    	 SceneBean bean = (SceneBean)it.next();  
				         if (bean.getSceneId() == delete){  
				        	 it.remove();
				        	 break;
				         }  
				     }  				
				}

				if(li != null){
				     for (Iterator it = li.iterator();it.hasNext();){    //reparations为Collection  
				    	 FavoriteBean bean = (FavoriteBean)it.next();  
				         if (bean.getSceneId() == delete){  
				        	 it.remove();
				        	 break;
				         }  
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
