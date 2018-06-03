package com.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comment.dto.Comment;
import com.comment.job.launcher.IncreaseEmpathyLauncher;
import com.comment.job.launcher.DecreaseEmpathyLauncher;
import com.comment.service.CommentService;
import com.comment.service.EmpathyService;

@RestController
public class HomeController {
	
	@Autowired
	EmpathyService empathyService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	IncreaseEmpathyLauncher increaseEmpathyLauncher;
	
	@Autowired
	DecreaseEmpathyLauncher decreaseEmpathyLauncher;
	
	@Cacheable(value = "comments", key = "#pg")
	@RequestMapping("findOne/{postId}/{page}")
	public List<Comment> findOne(@PathVariable("postId") String postId, @PathVariable("page") String pg) {
		System.out.println("cache");
		return commentService.findOne(Integer.parseInt(postId), Integer.parseInt(pg));
	}

	@RequestMapping("insertEmpathy/{userId}/{commentId}")
	public void insertEmpathy(@PathVariable("userId") int userId, @PathVariable("commentId") int commentId) {
		long startTime = System.currentTimeMillis();
		empathyService.insertEmpathy(userId, commentId);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
        System.out.println("공감 3000개 insert time = " + elapsedTime);
	}
	
	@RequestMapping("deleteEmpathy/{userId}/{commentId}")
	public void deleteEmpathy(@PathVariable("userId") int userId, @PathVariable("commentId") int commentId) {
		empathyService.deleteEmpathy(userId, commentId);
	}
	
	@RequestMapping("increaseEmpathyJob/run")
	public void increaseEmpathyJob(){
		System.out.println("배치시작");
		long startTime = System.currentTimeMillis();
		increaseEmpathyLauncher.start();
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
        System.out.println("배치 처리 time = " + elapsedTime);
	}
	
	@RequestMapping("decreaseEmpathyJob/run")
	public void decreaseEmpathyJob(){
		decreaseEmpathyLauncher.start();
	}
}
