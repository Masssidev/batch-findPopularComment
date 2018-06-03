package com.comment.dao.redis;

public interface EmpathyDAO {
	void insertEmpathy(int userId, int commentId);
	void deleteEmpathy(int userId, int commentId);
}
