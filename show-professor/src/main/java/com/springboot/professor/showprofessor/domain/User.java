package com.springboot.professor.showprofessor.domain;

/**
 * User �û�ʵ��
 * @author Administrator
 *
 */

public class User {
	private Long id;//ʵ���Ψһ��ʶ
	private String name;
	private String email;
	
	public User() {
		
	}
	public User(Long id,String name,String email) {
		this.id = id;
		this.email = email;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
