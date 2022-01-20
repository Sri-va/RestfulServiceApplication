package com.htc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.services.TagService;

@RestController
@RequestMapping("/api/tags")
public class TagController {

	@Autowired
	TagService tagservice;
	
	// mapping operations ..
}
