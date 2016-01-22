package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.MemberBean;
import model.bean.ThoughtBean;
import model.service.ThoughtService;
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
		String temp3 = request.getParameter("thoughtSubtitle");
		String temp4 = request.getParameter("thoughtContent");
		if(session.getAttribute("loginOk") == null){
			request.getRequestDispatcher("/secure/login.jsp").forward(request, response);
			return;
		}
		MemberBean mb = (MemberBean)session.getAttribute("loginOk");
		int temp5 = mb.getMemberId();
		
		
		
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
			errors.put("thoughtSubtitle", "請輸入標題");
		}
		if(temp4 == null || temp4.trim().length()==0){
			errors.put("thoughtContent", "請輸入內容");
		}
		
		Collection<Part> parts = request.getParts();
		Part pho = request.getPart("thoughtPhoto");
		byte[] photo = null;
		if(pho!=null){
			InputStream is = pho.getInputStream();
			photo = new byte[(int)pho.getSize()];
			is.read(photo);
//			OutputStream os = new FileOutputStream("C:/Users/Student/Desktop/A01.jpg");
//			os.write(photo);
//			os.close();
			is.close();
		}
		if(pho == null){
			errors.put("thoughtPhoto", "請選一張代表此心得的照片");
		}
		
		if(errors != null && !errors.isEmpty()){
			request.getRequestDispatcher("/thought/Thought.jsp").forward(request, response);
			return;
		}
			
		//轉換資料
		
		//model
//		ThoughtDAO thoughtDao = new ThoughtDAOjndi();
		ThoughtBean bean = new ThoughtBean();
		ThoughtService ts = new ThoughtService();
//		int temp5 = mb.getMemberId();
//		String content = ("<span>"+temp4+"</span>");
		bean.setThoughtId(1);
		bean.setThoughtName(temp2);
		bean.setThoughtSubtitle(temp3);
//		bean.setThoughtContent(TypeConveter.EncodeStringBase64(temp4));
		bean.setThoughtPhoto(photo);
		bean.setThoughtContent(temp4);
//		bean.setMemberId(1);
		bean.setMemberId(temp5);
		ThoughtBean inbean = ts.insert(bean);
//		ThoughtBean b=thoughtDao.select(inbean.getThoughtId());
//		System.out.println("insert"+inbean);
//		System.out.println("select"+b);
		
		//model執行結果，View
		if(inbean != null){
			session.setAttribute("thought",inbean );
			String path = request.getContextPath();
			response.sendRedirect(path+"/thought/ThoughtPage.jsp");
//			response.sendRedirect("index.jsp");
//			request.getRequestDispatcher("game.jsp").forward(request, response);
//			System.out.println("AAABBB");
		}else{
			request.getRequestDispatcher("/thought/Thought.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
