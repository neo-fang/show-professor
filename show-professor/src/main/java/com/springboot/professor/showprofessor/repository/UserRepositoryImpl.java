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
 * 用户资源库UserRepository实现
 * @author Administrator
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
	//实现用户id的唯一性
	private static AtomicLong counter = new AtomicLong();
	//将用户信息存储在内存userMap中
	private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap();
	
	@Override
	public User savaOrUpdateUser(User user) {
		Long id = user.getId();
		if(id==null) {//新建的用户
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
