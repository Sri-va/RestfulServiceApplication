package com.htc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.dao.TagRepository;

@Service
public class TagService {

	@Autowired
	TagRepository tagrepository;
	
	// crud operations ...
}
