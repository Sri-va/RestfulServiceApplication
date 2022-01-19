package com.htc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tag")
public class Tag {
 @Id
 private int tagId;
 private String name;
 @ManyToOne
 @JoinColumn(name = "userId")
 private Topic topic;
public int getTagId() {
	return tagId;
}
public void setTagId(int tagId) {
	this.tagId = tagId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Topic getTopic() {
	return topic;
}
public void setTopic(Topic topic) {
	this.topic = topic;
}
}
