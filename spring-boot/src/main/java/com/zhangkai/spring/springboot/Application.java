package com.zhangkai.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.zhangkai.spring.springboot.configbean.Book;
import com.zhangkai.spring.springboot.configbean.BookSerializer;

/**
 * 
 * @author and04
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;

	/**
	 * 
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Book> bookRedisTemplate() {
		RedisTemplate<String, Book> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new BookSerializer());
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		return redisTemplate;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		// 图标
		application.setBannerMode(Banner.Mode.OFF); 
		application.run(args);
	}
}
