package com.comment.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.comment.dto.Comment;

@Mapper
public interface CommentMapper {
	List<Comment> findOne(int postId, int pg);
}
