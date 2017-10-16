package com.wipro.SpringRest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.SpringRest.domain.User;
@Service
public interface UserService  //User Interface to declare the oprating abstract methods
{

	public User createProfile(User user);
	public String updateProfile(User user);
	public String deleteProfile(User user);
	public List<User> getAll();
	public User getById(int id);
	


}