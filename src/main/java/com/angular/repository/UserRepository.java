/**
 * 
 */
package com.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angular.domain.User;

/**
 * @author GowrishankarB
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUserNameAndPassword(String username,String password);

}