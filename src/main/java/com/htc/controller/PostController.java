package com.htc.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.dao.PostRepository;
import com.htc.model.MyUsers;
import com.htc.model.Post;
import com.htc.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	PostService postservice;
	

	@PostMapping("/addpost")
	public ResponseEntity<String> addPost(@RequestBody Post post) {
		
		if(postservice.save(post))
			return new ResponseEntity<String>("User Added Successfully", HttpStatus.ACCEPTED);
		 
		 return new ResponseEntity<String>("Fatal error. Post could not be added. Try again !!!", HttpStatus.BAD_REQUEST);
		
	} 
	
	@GetMapping("/getallposts/{userid}")
	public Set<Post> getAllPostsByUserID(@PathVariable(value="userid") int id){
		
		return postservice.getAllPostsByUserID(id);
		
	}

}
