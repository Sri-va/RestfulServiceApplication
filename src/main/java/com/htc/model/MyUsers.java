package com.htc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MyUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
	public Set<Topic> topics=new HashSet<Topic>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
	public Set<Post> posts=new HashSet<Post>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	
	public MyUsers(int id, String name, String password, String email) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public MyUsers() {
		
	}
	
}
