package com.htc.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.htc.dao.PostRepository;
import com.htc.model.Post;

@Service
public class PostService {

	@Autowired
	PostRepository postrepository;
	
	//crud operations ..
	
	public boolean save(Post post) {
		
		if(postrepository.existsById(post.getId()))
			return false;
		
		return postrepository.save(post)!=null;
	} 
	
	public Set<Post> getAllPostsByUserID(int id){
		
		return postrepository.findAllByUserId(id);
		
	}
}
