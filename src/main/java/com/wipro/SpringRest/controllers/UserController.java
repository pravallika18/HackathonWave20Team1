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
	  public ResponseEntity<User> createUser(@RequestBody User user) 
	  {
	      User savedUser=userService.save(user);
	        return ResponseEntity.ok(savedUser);
		 
	  	}
	  
	  @RequestMapping(method=RequestMethod.PUT)
	  public ResponseEntity<String> updateExist(@RequestBody Places places)  {
	   try {
//		    places.setId(5);
		    if(placesService.update(places).equals("data Updated successfully")){
		    return ResponseEntity.ok("updated successfully");
		    		}
		    else {
		    	throw new PlaceNotFoundException("Place not Found to update");
		    }
	   } catch (PlaceNotFoundException e) {
	    return ResponseEntity.ok("Place not Found to update");
	   }
	 }
	  
	  
	  @RequestMapping(method=RequestMethod.DELETE)
	  public ResponseEntity<String> deleteById(@RequestBody Places places)  {
	   try {
//		    places.setId(5);
		    if(placesService.delete(places).equals("Deleted succesfully")){
		    return ResponseEntity.ok("data deleted successfully");
		    		}
		    else {
		    	throw new PlaceNotFoundException("Place not Found to delete");
		    }
	   } catch (PlaceNotFoundException e) {
	    return ResponseEntity.ok("Place not Found to delete");
	   }
	  }

		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		/** @PathVariable,(/id?id=1)
		getById(@Requestparam int id) (/1) **/
		
		public ResponseEntity<Places> getById(@PathVariable int id)  {
			Places place=placesService.findById(id);
			
			return ResponseEntity.ok(place);
		
		}
	}

	

}
