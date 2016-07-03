package test;

import infrastructure.InMemoryRepository;
import junit.framework.TestCase;
import repository.UserRepository;

public class Test extends TestCase {

	UserRepository userrepo;

	protected void setUp() throws Exception {
		userrepo = new InMemoryRepository();
	}

	public void testRegisterNew() {
		assertEquals(userrepo.findAll().size(), 2);
	}
}
