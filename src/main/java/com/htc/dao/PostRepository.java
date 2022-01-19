package com.htc.dao;



import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.htc.model.Post;
import com.htc.model.MyUsers;


public interface PostRepository extends JpaRepository<Post, Integer> {

	
	@Query("from Post where user_id = :userid")
	public Set<Post> findAllByUserId(@Param("userid") int userid);
}
