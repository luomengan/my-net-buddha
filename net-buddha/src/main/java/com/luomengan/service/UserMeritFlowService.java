package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.UserMeritFlowDao;
import com.luomengan.entity.UserMeritFlow;

/**
 * 用户功德流水 Service
 * 
 * @author luomengan
 *
 */
@Service
public class UserMeritFlowService {

	@Autowired
	private UserMeritFlowDao userMeritFlowDao;

	public UserMeritFlow getUserMeritFlowInfo(Integer id) {
		return userMeritFlowDao.retrieveUserMeritFlowById(id);
	}

	@Transactional
	public UserMeritFlow addUserMeritFlow(UserMeritFlow userMeritFlow) {
		return userMeritFlowDao.createUserMeritFlow(userMeritFlow);
	}

	@Transactional
	public UserMeritFlow modifyUserMeritFlow(UserMeritFlow userMeritFlow) {
		return userMeritFlowDao.updateUserMeritFlow(userMeritFlow);
	}

	@Transactional
	public void deleteUserMeritFlow(Integer id) {
		userMeritFlowDao.deleteUserMeritFlowById(id);
	}
	
	@Transactional
	public void deleteUserMeritFlows(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					userMeritFlowDao.deleteUserMeritFlowById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<UserMeritFlow> userMeritFlows(int page, int limit) {
		return userMeritFlowDao.pageUserMeritFlow(page, limit);
	}
	
	public List<UserMeritFlow> list() {
		return userMeritFlowDao.listUserMeritFlow();
	}

}
