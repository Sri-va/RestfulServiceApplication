package com.htc.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.dao.PostRepository;
import com.htc.dao.TopicRepository;
import com.htc.model.Post;
import com.htc.model.Topic;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

	@Autowired
	TopicRepository topicrepository;
	
	@PostMapping("/addtopic")
	public Topic addTopic(@RequestBody Topic topic) {
		
		return topicrepository.save(topic);
		
	} 
	
	@GetMapping("/get/{id}")
	public Topic getTopicByID(@PathVariable(value="id") int id){
		
		return topicrepository.findById(id).orElse(null);
		
	}
}
