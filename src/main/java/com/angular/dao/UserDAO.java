/**
 * 
 */
package com.angular.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.angular.domain.User;
import com.angular.repository.UserRepository;

/**
 * @author GowrishankarB
 * 
 */
@Repository
@Transactional
public class UserDAO {

	
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		if(user != null){
			return userRepository.saveAndFlush(user);
		}
		return null;
	}

	public User findByUserNameAndPassword(String username, String password) {
	if(username != null && password != null){
		return userRepository.findByUserNameAndPassword(username, password);
	}
	return null;
  }
	
	public List<User> listusUsers() {
		List<User> users = userRepository.findAll();
		if(users.size() > 0 && !users.isEmpty()){
			return users;
		}
		return null;
	}

	public User getUser(Integer id) {
		if(id != 0){
			return userRepository.findOne(id);
		}
		return null;
	}

	public boolean deleteuser(Integer id) {
		if(id != 0){
			userRepository.delete(id);
			return true;
		}
		return false;
	}
}
