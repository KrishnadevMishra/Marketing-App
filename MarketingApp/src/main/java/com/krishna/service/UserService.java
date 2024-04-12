package com.krishna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krishna.dao.UserDao;
import com.krishna.dto.ResponseStructure;
import com.krishna.dto.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public ResponseStructure<User> saveUser(@RequestBody User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setBody(userDao.saveUser(user));
		structure.setMessage("User saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}
	public ResponseStructure<User> updateUser(@RequestBody User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setBody(userDao.saveUser(user));
		structure.setMessage("User Updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}
	public ResponseStructure<User> deleteUser(@PathVariable long id){
		Optional<User> recUser=userDao.findById(id);
		ResponseStructure<User> structure=new ResponseStructure<>();
		if(recUser.isPresent()) {
			userDao.deleteById(id);
			structure.setMessage("User found and deleted");
			structure.setCode(HttpStatus.FOUND.value());
		}else {
			structure.setBody(null);
			structure.setMessage("User Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}
	public ResponseStructure<User> findUserById(@PathVariable long id){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.findById(id);
		if(recUser.isPresent()) {
			userDao.deleteById(id);
			structure.setMessage("User found ");
			structure.setBody(recUser.get());
			structure.setCode(HttpStatus.FOUND.value());
		}else {
			structure.setBody(null);
			structure.setMessage("User Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}
	public ResponseStructure<List<User>> findAllUsers(){
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setBody(userDao.findAll());
		structure.setMessage("list of users");
		structure.setCode(HttpStatus.OK.value());
		return structure;
	}
	

}
