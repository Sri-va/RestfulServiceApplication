package com.htc.controller;

import org.springframework.http.ResponseEntity;

import com.htc.model.MyUsers;

public interface IUserController {
	public MyUsers AddUser(MyUsers user);
	public ResponseEntity<String> DeleteUser(int userId);
	public ResponseEntity<MyUsers> getUser(int UserId);
	

}
