package com.example.redis;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
//		String token = JwtUtils.creatJWT("1",  60000L);
//
//		//解析
//		try
//		{
//			log.info("生成token=:" + token);
//			Claims claims = com.example.redis.utils.JwtUtils.parseJWT(token);
//			log.info("解析成功：" + claims.getSubject());
//		}
//		catch(Exception e)
//		{
//			log.info("解析失敗:");
//			e.printStackTrace();
//		}
//	}
	}
}
