package com.htc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Topic")
public class Topic {

@Id
private int topicId;
 private String title;
 private String createdAt;
 private String updatedAt;
 private User Author;
 private Tag tag;

 private Post post;
public int getTopicId() {
	return topicId;
}
public void setTopicId(int topicId) {
	this.topicId = topicId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
public String getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
}
public User getAuthor() {
	return Author;
}
public void setAuthor(User author) {
	Author = author;
}
public Tag getTag() {
	return tag;
}
public void setTag(Tag tag) {
	this.tag = tag;
}
public Post getPost() {
	return post;
}
public void setPost(Post post) {
	this.post = post;
}
public Topic(int topicId, String title, String createdAt, String updatedAt, User author, Tag tag, Post post) {
	super();
	this.topicId = topicId;
	this.title = title;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	Author = author;
	this.tag = tag;
	this.post = post;
}
}
