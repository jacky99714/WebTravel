package jacky.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.MemberBean;
import model.service.MemberService;

@WebServlet("/MemberImg")
public class MemberImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberImg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("image/gif; charset=UTF-8");
	    MemberService ms = new MemberService();
		String id = request.getParameter("memberId");
		if(id!=null){
			MemberBean mBean = ms.selectMember(Integer.parseInt(id));
			byte[] phto = mBean.getPhoto();
			OutputStream out = response.getOutputStream();
			out.write(phto);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
