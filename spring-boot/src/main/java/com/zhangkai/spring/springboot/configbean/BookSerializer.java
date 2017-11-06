package com.zhangkai.spring.springboot.configbean;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author and04
 *
 */
public class BookSerializer implements RedisSerializer<Book> {

	@Override
	public byte[] serialize(Book t) throws SerializationException {
		ObjectMapper om = new ObjectMapper();
		try {
			return om.writeValueAsBytes(t);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public Book deserialize(byte[] bytes) throws SerializationException {
		ObjectMapper om = new ObjectMapper();
		try {
			return om.readValue(bytes, Book.class);
		} catch (Exception e) {
			return null;
		}
	}

}
