package misc;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import model.hibernate.HibernateUtil;
@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory();

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.closeSessionFactory();

	}

}
