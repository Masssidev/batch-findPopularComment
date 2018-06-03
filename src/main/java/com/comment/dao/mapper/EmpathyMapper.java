package com.comment.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpathyMapper {
	void updateIncreaseEmpathy(List<? extends Integer> empathies);
	void updateDecreaseEmpathy(List<? extends Integer> empathies);
}
