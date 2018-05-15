package com.wsh.springbootandcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringbootandcloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootandcloudApplication.class, args);
	}
}
