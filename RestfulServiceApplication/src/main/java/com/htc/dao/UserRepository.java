package com.htc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
