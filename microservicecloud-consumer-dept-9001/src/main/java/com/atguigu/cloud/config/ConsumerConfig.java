package com.atguigu.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerConfig {

	@Bean
//	@LoadBalanced 巨坑。。。。。。。
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
