package com.htc.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.dao.TopicRepository;
import com.htc.model.Topic;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicrepository;
	
	//crud operations ..
	
	public boolean addTopic(Topic topic) {
		
		if(topicrepository.existsById(topic.getId()))
			return false;
		
		return topicrepository.save(topic)!=null;
		
	}
	
	public Topic getTopicByID(int id){
		
		return topicrepository.findById(id).orElse(null);
		
	}
	
   public Set<Topic> getAllTopicsByUserID(int id){
		
		return topicrepository.findAllByUserId(id);
		
	}
}
