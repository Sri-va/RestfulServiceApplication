package com.htc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
