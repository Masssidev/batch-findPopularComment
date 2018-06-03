package com.comment.dto;

public class Comment {
	private int id;
	private int post_id;
	private int user_id;
	private String body;
	private int empathy;
	private int not_empathy;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getEmpathy() {
		return empathy;
	}
	public void setEmpathy(int empathy) {
		this.empathy = empathy;
	}
	public int getNot_empathy() {
		return not_empathy;
	}
	public void setNot_empathy(int not_empathy) {
		this.not_empathy = not_empathy;
	}
	
}
