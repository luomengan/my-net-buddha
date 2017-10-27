package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.UserMeritFlowDao;
import com.luomengan.dao.impl.jpa.UserMeritFlowRepository;
import com.luomengan.entity.UserMeritFlow;

/**
 * 用户功德流水 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class UserMeritFlowDaoImpl implements UserMeritFlowDao {

	@Autowired
	private UserMeritFlowRepository userMeritFlowRepository;

	@Override
	public UserMeritFlow createUserMeritFlow(UserMeritFlow userMeritFlow) {
		return userMeritFlowRepository.save(userMeritFlow);
	}

	@Override
	public void deleteUserMeritFlowById(Integer id) {
		userMeritFlowRepository.delete(id);
	}

	@Override
	public UserMeritFlow updateUserMeritFlow(UserMeritFlow userMeritFlow) {
		return userMeritFlowRepository.save(userMeritFlow);
	}

	@Override
	public UserMeritFlow retrieveUserMeritFlowById(Integer id) {
		return userMeritFlowRepository.findById(id);
	}

	@Override
	public Page<UserMeritFlow> pageUserMeritFlow(int page, int limit) {
		return userMeritFlowRepository.findAll(new PageRequest(page, limit));
	}
	
	@Override
	public List<UserMeritFlow> listUserMeritFlow() {
		return userMeritFlowRepository.findAll();
	}

}
