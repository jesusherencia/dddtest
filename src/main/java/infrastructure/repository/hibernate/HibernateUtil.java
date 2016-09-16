package infrastructure.repository.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static HibernateUtil instance = new HibernateUtil();

	private SessionFactory sessionFactory;

	private HibernateUtil() {
		this.sessionFactory = buildSessionFactory();
	}

	private synchronized static SessionFactory buildSessionFactory() {
		SessionFactory s = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		try {
			s = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
		return s;
		//return new Configuration().configure().buildSessionFactory();
		
	}

	public static HibernateUtil getInstance() {
		if (instance == null) {
			return new HibernateUtil();
		}
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession() throws HibernateException {
        Session sess = null;
        try {
            sess = sessionFactory.getCurrentSession();
        } catch (org.hibernate.HibernateException he) {
            sess = sessionFactory.openSession();
        }
        return sess;
    }

}