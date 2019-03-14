package com.springboot.professor.showprofessor.repository;

import java.util.List;

import com.springboot.professor.showprofessor.domain.User;

/**
 * User Repository�ӿڣ�����ʵ�ֶ��û�����ɾ�Ĳ�
 * @author Administrator
 *
 */
public interface UserRepository {
	//���������޸��û�
	User savaOrUpdateUser(User user);
	
	//ɾ���û�
	void deleteUser(Long id);
	
	//����id��ѯ�û�
	User getUserById(Long id);
	
	//��ȡ�û��б�
	List<User> listUsers();
}
