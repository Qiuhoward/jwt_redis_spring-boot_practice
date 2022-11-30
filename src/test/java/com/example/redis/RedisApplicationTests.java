package com.example.redis;
//
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;




@RunWith(SpringRunner.class)
@SpringBootTest
class RedisApplicationTests {
	@Autowired
	private  RedisTemplate<String, Object> redisTemplate;

//	/*测试redis 连接是否成功*/
	@Test
	void TestGetConnection(){
		RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
		System.out.println(factory);

		if (factory != null){
			RedisConnection connection = Objects.requireNonNull(redisTemplate.getConnectionFactory().getConnection());
			System.out.println(connection.toString());
			System.out.println(connection.ping());
		}

	}
//
//
//@Test
//void setObject(){
//	User user = new User();
//	user.setName("aa");
//	user.setAge(23);
//	user.setHeight(172);
//	user.setWeight(100);
//	redisTemplate.opsForValue().set("user",user);
//	System.out.println(redisTemplate.opsForValue().get("user"));
//}
//
//
//
//
//
//	@Test
//	void set(){
//	ValueOperations oops= redisTemplate.opsForValue();
//	oops.set("age",18);
//	}
//	@Test
//	void get(){
//	ValueOperations oops= redisTemplate.opsForValue();
//	Object age=oops.get("age");
//	System.out.println(age);
//	}
////	@Test
////	void getName(){
////		ValueOperations oops= redisTemplate.opsForValue();
////		Object name=oops.get("name");
////		System.out.println(name);
////	}
//	@Test
//	void hset(){
//		HashOperations oops= redisTemplate.opsForHash();
//		oops.put("info","a","aa");
//
//	}
//	@Test
//	void hget(){
//		HashOperations oops=redisTemplate.opsForHash();
//		Object value= oops.get("info","a");
//		System.out.println(value);
//	}
//

}
