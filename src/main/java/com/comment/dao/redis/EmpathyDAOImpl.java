package com.comment.dao.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

@Repository
public class EmpathyDAOImpl implements EmpathyDAO {

	@Resource(name = "redisTemplate")
	private ListOperations<String, Integer> listOperations;

	@Resource(name = "redisTemplate")
	private SetOperations<String, Integer> setOperations;

	@Override
	public void insertEmpathy(int userId, int commentId) {
		if (!setOperations.isMember("empathy:" + commentId, userId)) {
			setOperations.add("empathy:" + commentId, userId);
			listOperations.rightPush("empathy", commentId);
		} else
			//TODO logger로 변경
			System.out.println("이미 공감한 댓글입니다.");
	}

	@Override
	public void deleteEmpathy(int userId, int commentId) {
		if (setOperations.isMember("empathy:" + commentId, userId)) {
			setOperations.remove("empathy:" + commentId, userId);
			listOperations.rightPush("nonEmpathy", commentId);
		} else
			//TODO logger로 변경
			System.out.println("이미 취소된 공감입니다.");
	}

}