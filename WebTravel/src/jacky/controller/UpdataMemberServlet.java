package jacky.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.JSONArray;

import model.bean.MemberBean;
import model.service.MemberService;


@WebServlet("/UpdataMemberServlet")
public class UpdataMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdataMemberServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json; charset=UTF-8");
		HttpSession session =request.getSession();
		PrintWriter out = response.getWriter();
		JSONArray jsonArray ;
		List<MemberBean> list = new ArrayList<MemberBean>();
		//接收
		String temp3 = request.getParameter("lastname");
		String temp4 = request.getParameter("firstname");
		String temp5 = request.getParameter("nickname");
		String temp7 = request.getParameter("cphone");
		String temp8 = request.getParameter("hphone");
		String temp9 = request.getParameter("email");
		String temp10 = request.getParameter("addr");
//		System.out.println("UpdataMemberServlet:"+temp10);
//		System.out.println("UpdataMemberServlet:"+temp3);
//		System.out.println("UpdataMemberServlet:"+temp5);
//		System.out.println("UpdataMemberServlet:"+temp6);
//		String temp11 = request.getParameter("photo");
		
		
//-----------------------------------------------------------
		//驗證
		Map<String, String> error =new HashMap<String,String>();
		request.setAttribute("errorMap",error);
		if(temp3==null || temp3.length()==0){
			error.put("lastname", "請輸入姓氏");
		}
		if(temp3==null || temp3.length()==0){
			error.put("firstname", "請輸入名字");
		}
		if(temp7==null || temp7.length()==0){
			error.put("cphone", "請輸入手機電話");
		}
		if(temp9==null || temp9.length()==0){
			error.put("email", "請輸入電子郵件");
		}
		if(error!=null && !error.isEmpty()){

			request.getRequestDispatcher(
					"/secure/login.jsp").forward(request, response);
		}else{
			//model
			MemberService ms = new MemberService();
			MemberBean mb = new MemberBean();
			MemberBean oldMb =(MemberBean)session.getAttribute("loginOk");
			mb.setUserName(oldMb.getUserName());
			mb.setLastName(temp3);
			mb.setFirstName(temp4);
			mb.setNickName(temp5);
			mb.setCellphone(temp7);
			mb.setTelephone(temp8);
			mb.setEmail(temp9);
			mb.setAddress(temp10);
			
			MemberBean rsbean = ms.updateContext(mb);
//			System.out.println("UpdataMemberSerlet:"+rsbean);
			//view
			if(rsbean!=null){
				if(rsbean.getPhoto()!=null){
					String phtoB64 =model.util.TypeConveter.EncodeBase64(rsbean.getPhoto());
					session.setAttribute("phtoB64", phtoB64);
				}
				session.removeAttribute("loginOk");
				session.removeAttribute("member");
				session.setAttribute("member", rsbean);
				session.setAttribute("loginOk", rsbean);
				list.clear();
				System.out.println("list.clear():"+list);
				list.add(rsbean);
				System.out.println("list:"+list);
				jsonArray = new JSONArray(list);
//				System.out.println("UpdataMemberServlet:"+jsonArray);
				out.print(jsonArray);
			}else{
				MemberBean mbs =(MemberBean)session.getAttribute("loginOk");
				list.add(mbs);
				jsonArray = new JSONArray(list);
				out.print(jsonArray);
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
