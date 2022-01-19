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

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	

	@PostMapping("/addpost")
	public Post AddUser(@RequestBody Post post) {
		
		return postRepository.save(post);
		
	} 
	
	@GetMapping("/getallposts/{userid}")
	public Set<Post> getAllPostsByUserID(@PathVariable(value="userid") int id){
		
		return postRepository.findAllByUserId(id);
		
	}

}
