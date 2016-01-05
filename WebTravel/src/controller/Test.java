package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.QBean;
import model.dao.QDAO;
import model.dao.jndi.QDAOjndi;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QDAO q = new QDAOjndi();
		QBean bean =new QBean();
		bean.setQName("QQ");
		bean.setA("A");
		bean.setB("B");
		bean.setC("C");
		bean.setD("D");
		bean.setAns("A");
	
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
		bean = q.insert(bean);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
