/**
 * 
 */
package com.angular.service;

import java.util.List;

import com.angular.domain.User;

/**
 * @author samy
 * 
 */
public interface UserService {
	
	public User saveUser(User user);

	public User findByUserNameAndPassword(String username, String password);
	
	public List<User> listusUsers();
	
	public User getUser(Integer id);
	
	public boolean deleteuser(Integer id);

}
