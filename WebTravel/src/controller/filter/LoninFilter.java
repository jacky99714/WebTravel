package controller.filter;

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

import model.bean.MemberBean;
import model.dao.jndi.MemberDAOjndi;
import model.dao.jndi.MemberMessageDAOjndi;

@WebFilter(
		 urlPatterns = "/*"
		)
public class LoninFilter implements Filter {

    private FilterConfig filterConfig;

	public LoninFilter() {
        
    }

	public void destroy() {
	
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println("LoginFilterBegin");
		HttpSession session=req.getSession();
		MemberBean mb =(MemberBean)session.getAttribute("loginOk");
		int mbMessageCount=0;
		if(mb!=null){
			MemberMessageDAOjndi jmd = new MemberMessageDAOjndi();
			mbMessageCount=jmd.count(mb.getMemberId());
		}
		session.setAttribute("mbMessageCount", mbMessageCount);
		
		chain.doFilter(request, response);
		

		System.out.println("LoginFilterEnd");
	}

	public void init(FilterConfig fConfig) throws ServletException {
        this.filterConfig = fConfig;
	}

}
