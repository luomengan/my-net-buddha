package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.UserMeritFlow;

/**
 * 用户功德流水 Dao
 * 
 * @author luomengan
 *
 */
public interface UserMeritFlowDao {

	public UserMeritFlow createUserMeritFlow(UserMeritFlow userMeritFlow);

	public void deleteUserMeritFlowById(Integer id);

	public UserMeritFlow updateUserMeritFlow(UserMeritFlow userMeritFlow);

	public UserMeritFlow retrieveUserMeritFlowById(Integer id);

	public Page<UserMeritFlow> pageUserMeritFlow(int page, int limit);
	
	public List<UserMeritFlow> listUserMeritFlow();

	public Integer retriveUserConsumeMerit(Integer userId);

}
