/**
 * 
 */
package com.angular.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.dao.UserDAO;
import com.angular.domain.User;
import com.angular.service.UserService;

/**
 * @author GowrishankarB
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public User saveUser(User user) {
		if(user != null){
			return userDAO.saveUser(user);
		}
		return null;
	}

	@Override
	public User findByUserNameAndPassword(String username, String password) {
		if(username != null && password != null){
			return userDAO.findByUserNameAndPassword(username, password);
		}
		return null;
	}

	@Override
	public List<User> listusUsers() {
		return userDAO.listusUsers();
	}

	@Override
	public User getUser(Integer id) {
		if(id != 0){
			return userDAO.getUser(id);
		}
		return null;
	}

	@Override
	public boolean deleteuser(Integer id) {
		if(id != 0){
			userDAO.deleteuser(id);
			return true;
		}
		return false;
	}
}
