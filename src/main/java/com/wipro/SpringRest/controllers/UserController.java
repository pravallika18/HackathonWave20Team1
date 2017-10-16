package com.wipro.SpringRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.SpringRest.domain.User;
import com.wipro.SpringRest.exeptions.UsernameAndEmailIdIsRequiredException;
import com.wipro.SpringRest.service.UserService;

@RestController
@RequestMapping("/v1.0/UserProfile/user")
public class UserController {
	@Autowired
	UserService userService;
	
	 @RequestMapping(method=RequestMethod.GET)
	   public ResponseEntity<List<User>> getAllUsers()
		{
		  	List<User> users=userService.getAll();
			return ResponseEntity.ok(users);
		}
	  
	  @RequestMapping(method=RequestMethod.POST)
	  public ResponseEntity<User> createUser(@RequestBody User user) throws UsernameAndEmailIdIsRequiredException 
	  {
		  if(user.getName().isEmpty()||user.getEmailId().isEmpty())
		  {
			  throw new UsernameAndEmailIdIsRequiredException("User name and EmailId is mandatory to create user profile");
		  }
		  else {
			  User savedUser=userService.createProfile(user);
		        return ResponseEntity.ok(savedUser);
		  }
	      
	  	}
	  
	  @RequestMapping(method=RequestMethod.PUT)
	  public ResponseEntity<String> updateUser(@RequestBody User user)  {
	  
		  String status=userService.updateProfile(user);
		  return ResponseEntity.ok(status);
	 }
	  
	  
	  @RequestMapping(method=RequestMethod.DELETE)
	  public ResponseEntity<String> deleteUser(@RequestBody User user)  {
		  String status=userService.deleteProfile(user);
		  return ResponseEntity.ok(status);
		  
	   
	  }

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<User> getUserById(@PathVariable int id)  {
			User user=userService.getById(id);
			
			return ResponseEntity.ok(user);
		
		}
	}

	


