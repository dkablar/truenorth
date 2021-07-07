package hr.truenorth.TrueNorth.Service;

import org.springframework.stereotype.Service;

import hr.truenorth.TrueNorth.Model.User;
import hr.truenorth.TrueNorth.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository iUserRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.iUserRepository = userRepository;
	}
	
	@Override
	public User getUserById(int id) {
		return iUserRepository.getUserById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return iUserRepository.getUserByUsername(username);
	}

}
