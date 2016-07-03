package infrastructure;

import java.util.ArrayList;
import java.util.List;

import model.User;
import repository.UserRepository;

public class InMemoryRepository implements UserRepository {

	private List<User> list;
	
	public InMemoryRepository() {
		super();
		list.add(new User(1, "a", "A", 10));
		list.add(new User(2, "b", "B", 20));
		// TODO Auto-generated constructor stub
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

	public User add(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(User t) {
		// TODO Auto-generated method stub
		return false;
	}

}
