package com.htc.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity

public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_id")
	public int id;
	@Column(name="text")
	public String text;
	@Column(name="created_at")
	public Date createdAt;
	@Column(name="updated_at")
	public Date updatedAt;
	
	@ManyToOne
	@JoinColumn(name="topic_id")
	private Topic topic;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private MyUsers author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public MyUsers getAuthor() {
		return author;
	}
	public void setAuthor(MyUsers author) {
		this.author = author;
	}
	public Post(int id, String text, Date createdAt, Date updatedAt) {
		
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", text=" + text + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", topic=" + topic + ", author=" + author + "]";
	}
	public Post() {
		
		// TODO Auto-generated constructor stub
	}
	

}
