package test;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.model.User;
import domain.repository.UserRepository;
import junit.framework.TestCase;

public class AppTestSpringHibernate extends TestCase {

	UserRepository userrepo;
	
	//SessionFactory sessionFactory;

	protected void setUp() throws Exception {
		//userrepo = new UserHibernateRepository();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		userrepo = (UserRepository) ctx.getBean("userRepository");
	}

	public void testAddUser() {
		int i = userrepo.findAll().size();
		userrepo.add(new User("c", "C", 30));
		assertEquals(i+1, userrepo.findAll().size());
	}
	
	/*public void testFindUser() {
		//int i = userrepo.findAll().size();
		User n = new User(3, "c", "C", 30);
		userrepo.add(n);
		assertEquals(n, userrepo.findById(3));
	}*/
}
