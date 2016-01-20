package jacky.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.MemberBean;
import model.service.MemberService;
import model.util.TypeConveter;

@WebServlet("/UpdataMemberImgServlet")
public class UpdataMemberImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdataMemberImgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json; charset=UTF-8");
	    MemberService ms = new MemberService();
		HttpSession session = request.getSession();
		MemberBean oldMb =(MemberBean)session.getAttribute("loginOk");
		Part img = request.getPart("photo");
		InputStream fi = img.getInputStream();
		byte[] phto = new byte[(int)img.getSize()];
		fi.read(phto);
		fi.close();
		if(oldMb!=null){
			oldMb.setPhoto(phto);
			MemberBean mb =ms.updata(oldMb);
			if(mb!=null){
				session.removeAttribute("loginOk");
				session.setAttribute("loginOk", mb);
				if(mb.getPhoto()!=null){
					String a = model.util.TypeConveter.EncodeBase64(mb.getPhoto());
					session.removeAttribute("memberimg");
					session.setAttribute("memberimg",a);
					response.sendRedirect(request.getContextPath()+"/JMember/MyMember.jsp");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
