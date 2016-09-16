package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.model.Role;
import junit.framework.TestCase;

public class AppTestHibernateJPA extends TestCase {

	EntityManagerFactory entityManagerFactory;

	protected void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory( "Tutorial" );
	}

	public void testAddUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist( new Role( "First Role") );
		entityManager.persist( new Role( "Second Role") );
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	/*public void testFindUser() {
		//int i = userrepo.findAll().size();
		User n = new User(3, "c", "C", 30);
		userrepo.add(n);
		assertEquals(n, userrepo.findById(3));
	}*/
}
