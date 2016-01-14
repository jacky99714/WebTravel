package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

import model.bean.ThoughtBean;
import model.service.ThoughtService;

/**
 * Servlet implementation class ShowThoughtServlet
 */
@WebServlet("/thought/ShowThoughtServlet")
public class ShowThoughtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowThoughtServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        
        ThoughtService ts = new ThoughtService();
       
        int id = Integer.parseInt(request.getParameter("id"));
         ThoughtBean bean = ts. getThoughtId(id);
         HttpSession session = request.getSession();
   
         session.setAttribute("thoughtBean", bean);
//         System.out.println("Bean  "+bean);
//         request.getRequestDispatcher("ShowThought.jsp").forward(request, response);
         response.sendRedirect("ShowThought.jsp");
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		this.doGet(request, response);
	}

}
