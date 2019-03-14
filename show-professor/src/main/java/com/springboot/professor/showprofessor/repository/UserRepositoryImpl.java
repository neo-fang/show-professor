package com.springboot.professor.showprofessor.repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.springboot.professor.showprofessor.domain.User;

/**
 * �û���Դ��UserRepositoryʵ��
 * @author Administrator
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
	//ʵ���û�id��Ψһ��
	private static AtomicLong counter = new AtomicLong();
	//���û���Ϣ�洢���ڴ�userMap��
	private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap();
	
	@Override
	public User savaOrUpdateUser(User user) {
		Long id = user.getId();
		if(id==null) {//�½����û�
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		this.userMap.remove(id);
	}

	@Override
	public User getUserById(Long id) {
		return this.userMap.get(id);
	}

	@Override
	public List<User> listUsers() {
		return new ArrayList<User>(this.userMap.values());
	}
	
}
