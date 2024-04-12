package com.krishna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.dto.ResponseStructure;
import com.krishna.dto.User;
import com.krishna.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	
	//http://localhost:9092/user
	@PostMapping("/user")
	public ResponseStructure<User> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	@PutMapping("/user")
	public ResponseStructure<User> updateUser(@RequestBody User user){
		return service.saveUser(user);
	}
	@DeleteMapping("/user/{id}")
	public ResponseStructure<User> deleteUser(@PathVariable long id){
		return service.deleteUser(id);
	}
	@GetMapping("/user/all")
	public ResponseStructure<List<User>> findAllUsers()
	{
		return service.findAllUsers();
	}
	@GetMapping("/user/{id}")
	public ResponseStructure<User> findUserById(@PathVariable long id)
	{
		return service.findUserById(id);
	}

}
