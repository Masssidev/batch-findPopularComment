package com.comment.service;

import java.util.List;

import com.comment.dto.Comment;

public interface CommentService {
	List<Comment> findOne(int postId, int pg);
}
