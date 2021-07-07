package hr.truenorth.TrueNorth.Service;

import hr.truenorth.TrueNorth.Model.User;

public interface UserService {

	public User getUserById(int id);
	
	public User getUserByUsername(String username);
}
