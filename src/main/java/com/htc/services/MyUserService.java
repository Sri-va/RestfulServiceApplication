package com.htc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.dao.UserRepository;
import com.htc.model.MyUsers;

@Service
public class MyUserService {

	@Autowired
	UserRepository userrepository;
	
	public boolean save(MyUsers user) {
		if(userrepository.existsById(user.getId()))
			return false;
		return userrepository.save(user)!=null;
	}
	
	public MyUsers getUserByID(int id) {
		return userrepository.findById(id).orElse(null);
	}
}
