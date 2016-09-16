package test;

import domain.model.User;
import domain.repository.UserRepository;
import infrastructure.repository.inmemory.UserInMemoryRepository;
import junit.framework.TestCase;

public class AppTestInMemory extends TestCase {

	UserRepository userrepo;

	protected void setUp() throws Exception {
		userrepo = new UserInMemoryRepository();
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
}
