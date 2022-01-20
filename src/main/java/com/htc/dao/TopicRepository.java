package com.htc.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.htc.model.Topic;


public interface TopicRepository extends JpaRepository<Topic,Integer> {

	@Query("from Topic where user_id = :userid")
	public Set<Topic> findAllByUserId(@Param("userid") int id);

}
