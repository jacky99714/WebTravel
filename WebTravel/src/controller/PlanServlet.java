package controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.util.TypeConveter;

/**
 * Servlet implementation class PlanServlet
 */
@WebServlet("/PlanServlet")
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

	    File file = new File("E:/bg.png");
	    FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		try {
		    for (int readNum; (readNum = fis.read(buf)) != -1;) {
		        bos.write(buf, 0, readNum); //no doubt here is 0
		        //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
		        System.out.println("read " + readNum + " bytes,");
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		String img = TypeConveter.base64Convert(bos.toByteArray());
		HttpSession session = request.getSession();
		session.setAttribute("img", img);

		

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
