package jacky.misc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(
//urlPatterns = "/SelectLocationServlet"
//)
public class SceneRFilter implements Filter {


    public SceneRFilter() {
    }

	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse resp = (HttpServletResponse) response;
//		System.out.println("SceneRFilterSceneRFilterBBBB");
//		HttpSession session = req.getSession();
//		session.removeAttribute("li");
//		if(session.getAttribute("li")!=null){
//			System.out.println("清除失敗");
//		}else{
//			System.out.println("清除成功");
//		}
		chain.doFilter(request, response);
		System.out.println("eeeeeeeeeeeeeeeeeeeee");
		
		
	}
	FilterConfig fConfig;
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig=fConfig;
		System.out.println("sss");
	}

}
