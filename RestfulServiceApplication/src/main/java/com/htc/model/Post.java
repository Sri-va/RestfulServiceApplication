package com.htc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post {
	@Id
	private int PostId;
	private String text;
	private String pcreatedAt;
	private String pupdatedAt;
	private Topic topic;
	private User user;
	
	
	public Post(int postId, String text, String pcreatedAt, String pupdatedAt, Topic topic, User user) {
		super();
		PostId = postId;
		this.text = text;
		this.pcreatedAt = pcreatedAt;
		this.pupdatedAt = pupdatedAt;
		this.topic = topic;
		this.user = user;
	}
	public int getPostId() {
		return PostId;
	}
	public void setPostId(int postId) {
		PostId = postId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPcreatedAt() {
		return pcreatedAt;
	}
	public void setPcreatedAt(String pcreatedAt) {
		this.pcreatedAt = pcreatedAt;
	}
	public String getPupdatedAt() {
		return pupdatedAt;
	}
	public void setPupdatedAt(String pupdatedAt) {
		this.pupdatedAt = pupdatedAt;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [PostId=" + PostId + ", text=" + text + ", pcreatedAt=" + pcreatedAt + ", pupdatedAt=" + pupdatedAt
				+ ", topic=" + topic + ", user=" + user + "]";
	}
	

}
