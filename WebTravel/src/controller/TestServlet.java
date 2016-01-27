package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import model.bean.ScheduleBean;
import model.bean.ScheduleContentBean;
import model.dao.hibernate.ScheduleContentDAOHibernate;
import model.dao.hibernate.ScheduleDAOHibernate;
import model.hibernate.HibernateUtil;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		ScheduleContentDAOHibernate dao = new ScheduleContentDAOHibernate(session);
//		ScheduleContentBean bean = new ScheduleContentBean();
//		bean.setSceneId(5);
//		bean.setScheduleId(2);
//		bean.setScheduleOrder(2);
//		bean.setScheduleContentId(25);
		
//		System.out.println(dao.selectSchedule(15));
		java.util.Date d = new java.util.Date();
		java.util.Date dd = new java.util.Date((d.getTime()+86400000L));
		System.out.println(dd);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
