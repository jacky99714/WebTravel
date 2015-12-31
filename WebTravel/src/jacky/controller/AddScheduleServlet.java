package jacky.controller;

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

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

import model.bean.SceneBean;
import model.service.MemberService;

@WebServlet("/AddScheduleServlet")
public class AddScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddScheduleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		List<String> list = new ArrayList<String>();
		list.clear();
		JSONArray jsonArray;
		JSONObject jsonObject =new JSONObject();
		HttpSession session = request.getSession();
//		session.removeAttribute("scheduleList");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF8");
		PrintWriter out= response.getWriter();
		MemberService memberService = new MemberService();
		String temp1 = request.getParameter("scene");
		
		int sceneId=0;
		if(temp1!=null&&temp1.length()!=0){
			sceneId = new Integer(temp1);
			List<SceneBean> scheduleList=(ArrayList<SceneBean>)session.getAttribute("scheduleList");
			System.out.println("scheduleList="+scheduleList);
			if(scheduleList!=null){
				for(SceneBean sceneBean :scheduleList){
					if(sceneBean.equals(memberService.selectSceneId(sceneId))){
						list.add("已在行程內");
						jsonArray=new JSONArray(list);
						System.out.println("jsonArray="+jsonArray);
						out.print(jsonArray);
						return;
					}
				}
				scheduleList.add(memberService.selectSceneId(sceneId));
				session.setAttribute("scheduleList", scheduleList);
				list.add("session 沒有此值 所以已加入");
				System.out.println(list);
				jsonArray=new JSONArray(list);
				out.print(jsonArray);
			}else{
				List<SceneBean> listSceneBean = new ArrayList<SceneBean>();
				SceneBean sceneBean =memberService.selectSceneId(sceneId);
				listSceneBean.add(sceneBean);
				session.setAttribute("scheduleList", listSceneBean);
				list.add("沒有此session 加入session 已加入");
				System.out.println(list);
				jsonArray=new JSONArray(list);
				out.print(jsonArray);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
