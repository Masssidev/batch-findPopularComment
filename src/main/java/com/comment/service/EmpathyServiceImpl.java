package com.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.dao.redis.EmpathyDAO;

@Service
public class EmpathyServiceImpl implements EmpathyService {
	
	@Autowired
	private EmpathyDAO empathyDAO;

	@Override
	public void insertEmpathy(int userId, int commentId) {
		empathyDAO.insertEmpathy(userId, commentId);
	}

	@Override
	public void deleteEmpathy(int userId, int commentId) {
		empathyDAO.deleteEmpathy(userId, commentId);
	}

}
