package com.htc.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.model.MyUsers;

public interface UserRepository extends JpaRepository<MyUsers,Integer> {

	
}
