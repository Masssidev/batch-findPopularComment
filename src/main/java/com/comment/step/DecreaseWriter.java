package com.comment.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comment.dao.mapper.EmpathyMapper;

@Component
public class DecreaseWriter implements ItemWriter<Integer> {

	@Autowired
	private EmpathyMapper empathyMapper;

	@Override
	public void write(List<? extends Integer> commentIdList) throws Exception {
		System.out.println("write");
		System.out.println(commentIdList);
		empathyMapper.updateDecreaseEmpathy(commentIdList);
	}
}
