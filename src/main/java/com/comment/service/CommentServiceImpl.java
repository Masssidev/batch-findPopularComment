package com.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.dao.mapper.CommentMapper;
import com.comment.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;

	@Override
	public List<Comment> findOne(int postId, int pg) {
		return commentMapper.findOne(postId, pg);
	}
}
