package com.htc.controller;

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
import com.htc.dao.TopicRepository;
import com.htc.model.Post;
import com.htc.model.Topic;
import com.htc.services.TopicService;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

	@Autowired
	TopicService topicservice;
	
	@PostMapping("/addtopic")
	public ResponseEntity<String> addTopic(@RequestBody Topic topic) {
		
		if(topicservice.addTopic(topic))
			return new ResponseEntity<String>("Topic Added Successfully", HttpStatus.ACCEPTED);
		 
		 return new ResponseEntity<String>("Fatal error. Topic could not be added. Try again !!!", HttpStatus.BAD_REQUEST);
		
	} 
	
	@GetMapping("/get/{id}")
	public Topic getTopicByID(@PathVariable(value="id") int id){
		
		return topicservice.getTopicByID(id);
		
	}
	
	@GetMapping("/getall/{userid}")
	public Set<Topic> getAllTopicsByUserID(@PathVariable(value="userid") int id){
		
		return topicservice.getAllTopicsByUserID(id);
		
	}
}
