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

import model.bean.ThoughtBean;
import model.dao.ThoughtDAO;
import model.dao.jndi.ThoughtDAOjndi;
import model.service.ThoughtService;
import model.util.TypeConveter;

@WebServlet("/DisplayThoughtServlet")
public class DisplayThoughtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayThoughtServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        
        System.out.println("AAAA");
//        String temp = request.getParameter("thoughtType");
//        System.out.println("temp"+temp);
        
//        ThoughtDAO thoughtDao = new ThoughtDAOjndi();
//        ThoughtBean bean = new ThoughtBean();
        ThoughtService ts = new ThoughtService();
        List<ThoughtBean> li = new ArrayList<>();
        li = ts.getAllThought();
        System.out.println(li);

//        PrintWriter out = response.getWriter();
//        out.print(TypeConveter.parseJSONArray(li));
        session.setAttribute("list", li);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
