package jacky.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SceneBean;
import model.dao.jndi.SceneDAOjndi;

/**
 * Servlet implementation class DataInsertServlet
 */
@WebServlet("/DataInsertServlet")
public class DataInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DataInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("application/json; charset=UTF-8");
		String location = request.getParameter("location");//區域
		String city = request.getParameter("city");//台中市...
		String sceneName = request.getParameter("sceneName");//名字
		String sceneContent = request.getParameter("sceneContent");//內容
		String timeStart = request.getParameter("timeStart");
		String timeEnd = request.getParameter("timeEnd");
		String photo = request.getParameter("photo");
		
		
		if("新北市".equals(city)||"基隆市".equals(city)||"台北市".equals(city)||"桃園市".equals(city)||"新竹縣".equals(city)||"宜蘭縣".equals(city)){
			location="北區";
		}else if("雲林縣".equals(city)||"南投縣".equals(city)||"彰化縣".equals(city)||"台中市".equals(city)||"苗栗縣".equals(city)){
			location="中區";
		}else if("金門縣".equals(city)||"澎湖縣".equals(city)||"屏東縣".equals(city)||"高雄市".equals(city)||"台南市".equals(city)||"嘉義縣".equals(city)){
			location="南區";
		}else{
			location="東區";
		}
		//圖片抓取
		ByteArrayOutputStream baos = null;
		byte[] bb=null;
		if (!photo.equals("")&&photo!=null) {
			baos = new ByteArrayOutputStream();
			URL url = new URL(photo);
			byte[] f = new byte[1024];
			InputStream fi = url.openStream();
			int n;
			while ((n = fi.read(f)) > 0) {
				baos.write(f, 0, n);
			}
			fi.close();
		}else{
			File f = new File("/Users/mouse/Desktop/wt.jpg");
			FileInputStream fi = new FileInputStream(f);
			bb = new byte[(int)f.length()];
			fi.read(bb);
			fi.close();
		}
		//
		SceneBean bean = new SceneBean();
		bean.setCity(city);
		bean.setLocation(location);
		bean.setSceneContent(sceneContent);
		bean.setSceneName(sceneName);
		if (baos!=null) {
			bean.setScenePhoto(baos.toByteArray());
		}else{
			bean.setScenePhoto(bb);
		}
		bean.setMemberId(1);
		if(baos!=null){
			SceneDAOjndi sDAO = new SceneDAOjndi();
			sDAO.insert(bean);
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
