package com.springboot.professor.showprofessor;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@EnableAutoConfiguration(exclude = { 
//org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class 
//})//本句的作用是禁用SpringSecurity登录需要默认密码的安全设置，否则每次都需要输入用户名和密码，
//由于@SpringBootApplication注解已经包含了@EnableAutoConfiguration，所以不再需要单独写

@SpringBootApplication(exclude = { 
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class 
		})//本句的作用是禁用SpringSecurity登录需要默认密码的安全设置，否则每次都需要输入用户名和密码
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
