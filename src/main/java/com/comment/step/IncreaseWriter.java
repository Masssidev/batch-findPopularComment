package com.comment.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comment.dao.mapper.EmpathyMapper;

@Component
@Scope("prototype")
public class IncreaseWriter implements ItemWriter<Integer> {

	@Autowired
	private EmpathyMapper empathyMapper;

	@Override
	public void write(List<? extends Integer> commentIdList) throws Exception {
		empathyMapper.updateIncreaseEmpathy(commentIdList);
	}
}
