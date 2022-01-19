package com.htc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.htc.dao.UserRepository;
import com.htc.exception.UserNotFoundException;
import com.htc.model.MyUsers;
import com.htc.model.Post;

@RestController
@RequestMapping("/api/user")
public class UserController implements IUserController{

	@Autowired
	UserRepository userRepo;
	
//	@Override
//	@PostMapping("/addUser")
//	public ResponseEntity<String> AddUser(MyUsers user) {
//		
//		userRepo.save(user);
//		ResponseEntity<String> userResponse = new ResponseEntity<String>("User Added Successfully", HttpStatus.ACCEPTED);
//		return  userResponse;
//	} 
	
	@Override
	public ResponseEntity<String> DeleteUser(int userId) {
		userRepo.deleteById(userId);
		ResponseEntity<String>successResponse = new ResponseEntity<String>("User Details deleted succesfully",HttpStatus.ACCEPTED);
		return successResponse;
				
	}

	@Override
	@GetMapping("/getuser/{id}")
	public ResponseEntity<MyUsers> getUser(@PathVariable(value="id") int userId) {
		
		MyUsers user = userRepo.findById(userId).orElse(null);
		ResponseEntity<MyUsers> successResponse = new ResponseEntity<MyUsers>(user,HttpStatus.ACCEPTED);
		return successResponse;
	}
	
	
	@GetMapping("/user/getall")
	public List<MyUsers> retriveAllUsers() {
	    System.out.println("Get all Detailss...");
	 
	    List<MyUsers> list = new ArrayList<>();
	    Iterable<MyUsers> users= userRepo.findAll();	 
	    users.forEach(list::add);
	    return list;
	 }
	
	@PostMapping(value="/users/add")
	public ResponseEntity<Object> createUsers(@RequestBody MyUsers user) {
	    System.out.println("Create User: " + user.getId() + "...");
	 
	    MyUsers savedUser= userRepo.save(user);
	    URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
			return ResponseEntity.ok().body(location);
	}
	
	 @DeleteMapping(value="/users/delete/{id}")
	 public ResponseEntity<String> removeUser(@PathVariable("id") int id) {
		 Optional<MyUsers> contactData = userRepo.findById(id);
		    if (!contactData.isPresent()) {
		    throw new UserNotFoundException("id-"+id);
		    }
		 
		 	 
		userRepo.deleteById(id);
		 
		return new ResponseEntity<String>("delete operation completed",HttpStatus.OK);
		 
	 }
	 
	 @GetMapping(value="/users/get/{id}")
	 public MyUsers retriveUser(@PathVariable("id") int id) {
		 Optional<MyUsers> userData = userRepo.findById(id);
		    if (!userData.isPresent()) {
		    throw new UserNotFoundException("id-"+id);
		    } 
		    return  userData.get();
	 }
	 
	 @PutMapping(value="/user/modify/{id}")
	 public ResponseEntity<MyUsers> modifyContact(@PathVariable("id") int id,@RequestBody MyUsers user) {
		 Optional<MyUsers> userData = userRepo.findById(id);
		    if (userData.isPresent()) {
		    	MyUsers retriveUser= userData.get();
			    retriveUser.setName(user.getName());
			    retriveUser.setPassword(user.getPassword());
			    retriveUser.setEmail(user.getEmail());
			    retriveUser.setId(user.getId());
			    MyUsers savedUser=userRepo.save(retriveUser);
			 
			 return new ResponseEntity<MyUsers>(savedUser, HttpStatus.ACCEPTED) ;
		    } 
		 
		    
		 throw new UserNotFoundException("id-"+id);
	 }

	 
	 //Mine
	 
	 @PostMapping("/adduser")
		public MyUsers AddUser(@RequestBody MyUsers user) {
			
			return userRepo.save(user);
			
		}
	 
	 @GetMapping("/get/{id}")
	 public MyUsers getUserByID(@PathVariable(value = "id") int id) {
		 return userRepo.findById(id).orElse(null);
	 }
	 


	
}
