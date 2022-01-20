package com.htc.model;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity

public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="topic_id")
	public int id;
	
	@Column(name="title")
	public String title;
	
	@Column(name="created_at")
	public Date createdAt;
	
	@Column(name="updated_at")
	public Date updatedAt;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TOPIC_TAG", 
    joinColumns = { @JoinColumn(name = "TOPIC_ID") }, 
    inverseJoinColumns = { @JoinColumn(name = "TAG_ID") })
	public Set<Tag> tags;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "topic")
	public Set<Post> posts;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private MyUsers author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
	public MyUsers getAuthor() {
		return author;
	}
	public void setAuthor(MyUsers author) {
		this.author = author;
	}
	public Topic() {
		
		// TODO Auto-generated constructor stub
	}
	public Topic(int id, String title, Date createdAt, Date updatedAt) {
		
		this.id = id;
		this.title = title;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", tags=" + tags + ", posts=" + posts + "]";
	}
	
	

}