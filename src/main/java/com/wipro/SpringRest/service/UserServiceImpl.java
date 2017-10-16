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
		
		return null;
	}

	@Override
	public String updateProfile(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProfile(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
