package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import model.bean.MemberBean;
import model.bean.SceneMessageBean;
import model.service.MemberService;
import model.service.SceneMessageService;

/**
 * Servlet implementation class SceneMessage
 */
@WebServlet("/SceneMessage")
public class SceneMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
		
		//接收
		String smes = request.getParameter("message");
		
		String sid = request.getParameter("sceneId");
		
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean)session.getAttribute("loginOk");
		int mid = mb.getMemberId();
		//System.out.println(smes);
		//驗證
		SceneMessageService sms = new SceneMessageService();
		if(smes != null ){
			SceneMessageBean smb = new SceneMessageBean();
			smb.setMemberId(mid);
			smb.setSceneId(Integer.valueOf(sid));
			smb.setMessageContent(smes);
			//insert
			SceneMessageBean smbnew = sms.insertmessage(smb);
			//insert後再讀取一次message
			SceneMessageService scenemessage = new SceneMessageService();
			MemberService ms = new MemberService();
			List<SceneMessageBean> listmessage = scenemessage.selectmessage(smbnew.getSceneId());
			session.setAttribute("listmessage", listmessage);	
			smbnew.setMenberBean(ms.logini(smbnew.getMemberId()));
			System.out.println(smbnew);
			PrintWriter out = response.getWriter();
			JSONObject jsonObject = new JSONObject(smbnew);
//			System.out.println("return message json:"+smb);
			out.println(jsonObject);
		}
			
		//轉換
		
		//model		
		
		
		
		
		//view
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
