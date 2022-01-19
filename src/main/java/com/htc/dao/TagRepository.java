package com.htc.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.model.Tag;
public interface TagRepository extends JpaRepository<Tag,Integer> {

}
