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
import other.bean.FavoriteBean;

@WebServlet("/AddScheduleServlet")
public class AddScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddScheduleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		list.clear();
		JSONArray jsonArray;
		JSONObject jsonObject =new JSONObject();
		HttpSession session = request.getSession();
//		session.removeAttribute("scheduleList");
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		MemberService memberService = new MemberService();
		String temp1 = request.getParameter("scene");
		
		int sceneId=0;
		if(temp1!=null&&temp1.length()!=0){
			sceneId = new Integer(temp1);
			List<SceneBean> scheduleList=(ArrayList<SceneBean>)session.getAttribute("scheduleList");
			List<FavoriteBean> scheduleListFB=(ArrayList<FavoriteBean>)session.getAttribute("scheduleList");
			System.out.println("scheduleList="+scheduleList);
			System.out.println("scheduleListFB="+scheduleListFB);
			if(scheduleList!=null){//session 有此行程所以要刪除此行程
				boolean n = true;//判斷session 是否有沒有行程 沒有此行程就去加入行程(false) 有此行程就刪除(true)
				for(SceneBean sceneBean :scheduleList){
					if(sceneBean.equals(memberService.selectSceneId(sceneId))){
						list.add("deletesuccess");
						scheduleList.remove(sceneBean);
						scheduleListFB=memberService.selectFavoriteBean(scheduleList);
						System.out.println("ADD scheduleListFB:"+scheduleListFB);
//						System.out.println("ADD scheduleList:"+scheduleList);
						session.setAttribute("scheduleList", scheduleList);
						session.setAttribute("scheduleListFB", scheduleListFB);
						jsonArray=new JSONArray(list);
						System.out.println("jsonArray="+jsonArray);
						n=false;
						out.print(jsonArray);
						return;
					}
				}
				if (n) {//session 裡面沒有此行程 所以將景點加入session
					scheduleList.add(memberService.selectSceneId(sceneId));
					scheduleListFB=memberService.selectFavoriteBean(scheduleList);
//					System.out.println("END scheduleList:"+scheduleList);
					System.out.println("END scheduleListFB:"+scheduleListFB);
					session.setAttribute("scheduleList", scheduleList);
					session.setAttribute("scheduleListFB", scheduleListFB);
					list.add("joinsuccess");
					System.out.println(list);
					jsonArray = new JSONArray(list);
					out.print(jsonArray);
				}
			}else{//如果沒有session  new 一個加入行程
				List<SceneBean> listSceneBean = new ArrayList<SceneBean>();
				SceneBean sceneBean =memberService.selectSceneId(sceneId);
				listSceneBean.add(sceneBean);
				scheduleListFB=memberService.selectFavoriteBean(listSceneBean);
//				System.out.println("END scheduleList:"+listSceneBean);
				System.out.println("END scheduleListFB:"+scheduleListFB);
				session.setAttribute("scheduleList", listSceneBean);
				session.setAttribute("scheduleListFB", scheduleListFB);
				list.add("joinsuccess");
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
