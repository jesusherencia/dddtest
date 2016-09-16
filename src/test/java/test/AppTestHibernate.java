package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import domain.model.User;
import domain.repository.UserRepository;
import infrastructure.repository.inmemory.UserInMemoryRepository;
import junit.framework.TestCase;

public class AppTestHibernate extends TestCase {

	UserRepository userrepo;
	
	SessionFactory sessionFactory;

	protected void setUp() throws Exception {
		userrepo = new UserInMemoryRepository();
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	public void testAddUser() {
		int i = userrepo.findAll().size();
		userrepo.add(new User("c", "C", 30));
		assertEquals(i+1, userrepo.findAll().size());
	}
	
	public void testFindUser() {
		//int i = userrepo.findAll().size();
		User n = new User("c", "C", 30);
		userrepo.add(n);
		assertEquals(n, userrepo.findById(3));
	}
	
	public void testHibernate(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new User("d", "D", 40));
		session.getTransaction().commit();
		List result = session.createQuery( "from User" ).list();
		session.close();
		assertEquals(1, result.size());
	}
	
	public void testListHibernate(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery( "from User" ).list();
	}
}
