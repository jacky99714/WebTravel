package jacky.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AndroidLogin")
public class AndroidLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AndroidLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json; charset=UTF-8");
	    String u = request.getParameter("usename");
	    String p = request.getParameter("password");
	    System.out.println(u+":"+p);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
