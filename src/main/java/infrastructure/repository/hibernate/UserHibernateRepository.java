package infrastructure.repository.hibernate;

import java.util.List;

import org.hibernate.Session;

import domain.model.User;
import domain.repository.UserRepository;

public class UserHibernateRepository extends HibernateRepository implements UserRepository {

	public UserHibernateRepository() {
		super();
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		/*for (User u : list) {
			if(u.getUserId().equals(id)) {
				return u;
			}
		}*/
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		getSession().beginTransaction();
		List<User> result = getSession().createQuery("from User").getResultList();
		getSession().getTransaction().commit();
		getSession().close();
		return result;
	}

	public User add(User t) {
		// TODO Auto-generated method stub
		getSession().beginTransaction();
		getSession().save(t);
		getSession().getTransaction().commit();
		getSession().close();
		return t;
	}

	public boolean remove(User t) {
		// TODO Auto-generated method stub
		//list.remove(t);
		return true;
	}

}
