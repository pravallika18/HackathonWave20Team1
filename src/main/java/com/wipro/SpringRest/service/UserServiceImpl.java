package com.wipro.SpringRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wipro.SpringRest.domain.User;
import com.wipro.SpringRest.repository.UserRepository;
@Component
public class UserServiceImpl implements UserService 
{

	@Autowired
	UserRepository userRepository;
	@Override
	public User createProfile(User user) {
		
		User createProfile=userRepository.save(user);
		return createProfile;
	}

	@Override
	public String updateProfile(User user) {
		
		userRepository.save(user);
		return "Successfully user updated";
	}

	@Override
	public String deleteProfile(User user) {
		
		userRepository.delete(user);
		return "User profile daleted";
	}

	@Override
	public List<User> getAll() {
		
		return (List<User>) userRepository.findAll();
		
	}

	@Override
<<<<<<< HEAD
	public String getById(int id) {
		userRepository.delete(id);
		return "Deleted by id Successfully";
=======
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> 869dea5f5198a2d3831d04aabf36b01ff6fc9652
	}

}
