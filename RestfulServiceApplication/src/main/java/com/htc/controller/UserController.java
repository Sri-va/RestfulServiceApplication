package com.htc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.dao.UserRepository;
import com.htc.model.User;

@RestController
@RequestMapping("/api/user")
public class UserController implements IUserController{

	@Autowired
	UserRepository userRepo;
	@Override
	@PostMapping("/addOffice")
	public ResponseEntity<String> AddUser(User user) {
		
		userRepo.save(user);
		ResponseEntity<String> userResponse = new ResponseEntity<String>("User Added Successfully", HttpStatus.ACCEPTED);
		return  userResponse;
	} 
		
		
	

	@Override
	public ResponseEntity<String> DeleteUser(int userId) {
		userRepo.deleteById(userId);
		ResponseEntity<String>successResponse = new ResponseEntity<String>("User Details deleted succesfully",HttpStatus.ACCEPTED);
		return successResponse;
				
	}

	@Override
	public ResponseEntity<User> getUser(int userId) {
		
		User user = userRepo.findById(userId).orElse(null);
		ResponseEntity<User> successResponse = new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		return successResponse;
	}

}
