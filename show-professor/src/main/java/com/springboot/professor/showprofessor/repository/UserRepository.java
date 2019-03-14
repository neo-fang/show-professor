package com.springboot.professor.showprofessor.repository;

import java.util.List;

import com.springboot.professor.showprofessor.domain.User;

/**
 * User Repository接口，用于实现对用户的增删改查
 * @author Administrator
 *
 */
public interface UserRepository {
	//创建或者修改用户
	User savaOrUpdateUser(User user);
	
	//删除用户
	void deleteUser(Long id);
	
	//根据id查询用户
	User getUserById(Long id);
	
	//获取用户列表
	List<User> listUsers();
}
