package misc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.hibernate.HibernateUtil;

@WebListener
public class SessionFactoryListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSessionFactory();
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.closeSessionFactory();
	}
}
