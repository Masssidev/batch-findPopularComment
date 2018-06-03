package com.comment.step;

import javax.annotation.Resource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IncreaseReader implements ItemReader<Integer> {
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, Integer> listOperations;
	
	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		Integer commentId = listOperations.leftPop("empathy");
		return (commentId == null ? null : commentId);
	}

}
