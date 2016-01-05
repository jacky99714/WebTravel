package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MemberBean;
import model.bean.ThoughtBean;
import model.dao.ThoughtDAO;
import model.dao.jndi.ThoughtDAOjndi;
import model.util.TypeConveter;

@WebServlet("/ThoughtServlet")
public class ThoughtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		// 接收資料
//		String temp1 = request.getParameter("thoughtID");
		String temp2 = request.getParameter("thoughtName");
		String temp3 = request.getParameter("thoughtType");
		String temp4 = request.getParameter("thoughtContent");
//		MemberBean mb = (MemberBean)session.getAttribute("loginOk");
		
		System.out.println("temp2"+temp2);
		System.out.println("temp3"+temp3);
		System.out.println("temp4"+temp4);
		
		
		//驗證資料
		Map<String, String> errors = new HashMap<String,String>();
		request.setAttribute("errors", errors);
//		if(temp1 == null || temp1.trim().length()==0){
//			errors.put("thoughtID", "請輸入心得id");
//		}
		if(temp2 == null || temp2.trim().length()==0){
			errors.put("thoughtName", "請輸入心得名稱");
		}
		if(temp3 == null || temp3.trim().length()==0){
			errors.put("thoughtType", "請選擇種類");
		}
		if(temp4 == null || temp4.trim().length()==0){
			errors.put("thoughtContent", "請輸入內容");
		}
//		if(mb == null){
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}
		if(errors != null && !errors.isEmpty()){
			request.getRequestDispatcher("/Thought.jsp").forward(request, response);
			return;
		}
			
		//轉換資料
//		int memberId = mb.getMemberId();
		
		//model
		ThoughtDAO thoughtDao = new ThoughtDAOjndi();
		ThoughtBean bean = new ThoughtBean();
		
//		int temp5 = mb.getMemberId();
		
		bean.setThoughtId(1);
		bean.setThoughtName(temp2);
		bean.setThoughtType(temp3);
		//bean.setThoughtContent(TypeConveter.EncodeStringBase64(temp4));
		bean.setThoughtContent(temp4);
		bean.setMemberId(2);
//		bean.setMemberId(temp5);
		ThoughtBean inbean = thoughtDao.insert(bean);
		ThoughtBean b=thoughtDao.select(inbean.getThoughtId());
		System.out.println("insert"+inbean);
		System.out.println("select"+b);
		
		//model執行結果，View
		if(inbean != null){
			//System.out.println("AAABBB");
			session.setAttribute("thought",inbean );
			String path = request.getContextPath();
			response.sendRedirect(path+"/index.jsp");
//			response.sendRedirect("index.jsp");
//			request.getRequestDispatcher("game.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/Thought.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
