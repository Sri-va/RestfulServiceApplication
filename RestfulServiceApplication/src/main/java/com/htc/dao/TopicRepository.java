package com.htc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.model.Topic;
public interface TopicRepository extends JpaRepository<Topic,Integer> {

}
