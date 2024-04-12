package com.krishna.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krishna.dto.User;
import com.krishna.repository.UserRepository;
import com.krishna.service.UserService;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public User userUpdate(User user) {
		return userRepository.save(user);
	}
	public Optional<User> findById(long id){
		return userRepository.findById(id);
	}
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}
	

}
