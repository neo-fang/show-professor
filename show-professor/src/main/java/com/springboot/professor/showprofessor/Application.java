package com.springboot.professor.showprofessor;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@EnableAutoConfiguration(exclude = { 
//org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class 
//})//����������ǽ���SpringSecurity��¼��ҪĬ������İ�ȫ���ã�����ÿ�ζ���Ҫ�����û��������룬
//����@SpringBootApplicationע���Ѿ�������@EnableAutoConfiguration�����Բ�����Ҫ����д

@SpringBootApplication(exclude = { 
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class 
		})//����������ǽ���SpringSecurity��¼��ҪĬ������İ�ȫ���ã�����ÿ�ζ���Ҫ�����û���������
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
