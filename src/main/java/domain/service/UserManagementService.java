package domain.service;

import java.util.List;

import domain.model.User;

public interface UserManagementService {

	public List<User> listUsersByCriteria(String criteria);
	
}
