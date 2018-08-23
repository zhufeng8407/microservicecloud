package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServer9080_App {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServer9080_App.class, args);
	}
}
