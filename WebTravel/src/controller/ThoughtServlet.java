package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThoughtBean;

@WebServlet("/ThoughtServlet")
public class ThoughtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收資料
		String temp1 = request.getParameter("ThoughtID");
		String temp2 = request.getParameter("thoughtName");
		String temp3 = request.getParameter("thoughtType");
		String temp4 = request.getParameter("thoughtContent");
		String temp5 = request.getParameter("MemberId");
		
		
		//驗證資料
		Map<String, String> errors = new HashMap<String,String>();
		request.setAttribute("errors", errors);
		
		if(temp1 == null || temp1.trim().length()==0){
			errors.put("ThoughtID", "請輸入心得id");
		}
		if(temp2 == null || temp2.trim().length()==0){
			errors.put("ThoughtName", "請輸入心得名稱");
		}
		if(temp3 == null || temp3.trim().length()==0){
			errors.put("ThoughtType", "請選擇種類");
		}
		if(temp4 == null || temp4.trim().length()==0){
			errors.put("ThoughtContent", "請輸入內容");
		}
		if(temp5 == null || temp5.trim().length()==0){
			errors.put("MemberId", "請輸入會員id");
		}
		if(errors != null && !errors.isEmpty()){
			request.getRequestDispatcher("/secure/Thought.jsp").forward(request, response);
		}
			
		//轉換資料
		
		
		//model
		
		//model執行結果，View
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
