/**
 * 
 */
package com.angular.controller;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angular.domain.User;
import com.angular.service.UserService;
import com.angular.util.Response;

@RestController
@RequestMapping("/ISISApp/restAPI")
public class LoginController {

	@Autowired
	UserService userService;

	//@Transactional
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response registerUser(@RequestBody User user) throws JSONException {
		User loggedUser = userService.findByUserNameAndPassword(user.getUserName(),user.getPassword());
		if (loggedUser != null) {
			return new Response(true, loggedUser.getId());
		} else {
			return new Response("Invalid Login Credentials", false);
		}
	}
	
	@RequestMapping(value="/listUsers", method=RequestMethod.GET , consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response listUser(){
		List<User> users = userService.listusUsers();
		if(!users.isEmpty()){
			 return new Response(true, users);
		}
		return new Response(false);
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response saveUser(@RequestBody User user) throws JSONException {
		if(user != null){
			userService.saveUser(user);
			return new Response("User saved successfully", true);
		}else{
			return new Response("User saved Un-suuccessfull", false);
		}
	}
	
	@RequestMapping(value = "/getUser/{id}" , method = RequestMethod.GET)
	public Response getUser(@PathVariable("id") String id) throws JSONException {
		Integer userId = Integer.parseInt(id);
		if(userId != 0){
			User user2 = userService.getUser(userId);
			return new Response(true,user2);
		}else{
			return new Response("Edit Failed", false);
		}
	}
	
	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.GET)
	public Response deleteUser(@PathVariable("id") String id){
		Integer userId = Integer.parseInt(id); 
		if(userId != 0){
			if(userService.deleteuser(userId)){
				List<User> users = userService.listusUsers();
				return new Response(true,users);
			}else{
				return new Response("Edit Failed", false);
			}
		}else{
			return new Response("User Invalid", false);
		}
	}
}