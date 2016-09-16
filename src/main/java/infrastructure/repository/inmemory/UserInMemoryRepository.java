package infrastructure.repository.inmemory;

import java.util.ArrayList;
import java.util.List;

import domain.model.User;
import domain.repository.UserRepository;

public class UserInMemoryRepository implements UserRepository {

	private List<User> list;
	
	public UserInMemoryRepository() {
		super();
		list = new ArrayList<User>();
		list.add(new User("a", "A", 10));
		list.add(new User("b", "B", 20));
		// TODO Auto-generated constructor stub
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		for (User u : list) {
			if(u.getUserId().equals(id)) {
				return u;
			}
		}
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

	public User add(User t) {
		// TODO Auto-generated method stub
		list.add(t);
		return t;
	}

	public boolean remove(User t) {
		// TODO Auto-generated method stub
		list.remove(t);
		return true;
	}

}
