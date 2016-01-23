package misc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import model.hibernate.HibernateUtil;

@WebFilter(
		urlPatterns={"/*"}
		)
public class OpenSessionInViewFilter implements Filter {
	private FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			chain.doFilter(req, resp);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			sessionFactory.getCurrentSession().beginTransaction().rollback();
			chain.doFilter(req, resp);
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
