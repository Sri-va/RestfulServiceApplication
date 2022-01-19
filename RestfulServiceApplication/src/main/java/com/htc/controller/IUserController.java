package com.htc.controller;

import org.springframework.http.ResponseEntity;

import com.htc.model.User;

public interface IUserController {
	public ResponseEntity<String> AddUser(User user);
	public ResponseEntity<String> DeleteUser(int userId);
	public ResponseEntity<User> getUser(int UserId);

}
