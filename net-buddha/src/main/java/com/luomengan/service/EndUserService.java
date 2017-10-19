package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.EndUserDao;
import com.luomengan.entity.EndUser;

/**
 * 终端用户 Service
 * 
 * @author luomengan
 *
 */
@Service
public class EndUserService {

	@Autowired
	private EndUserDao endUserDao;

	public EndUser getEndUserInfo(Integer id) {
		return endUserDao.retrieveEndUserById(id);
	}

	@Transactional
	public EndUser addEndUser(EndUser endUser) {
		return endUserDao.createEndUser(endUser);
	}

	@Transactional
	public EndUser modifyEndUser(EndUser endUser) {
		return endUserDao.updateEndUser(endUser);
	}

	@Transactional
	public void deleteEndUser(Integer id) {
		endUserDao.deleteEndUserById(id);
	}
	
	@Transactional
	public void deleteEndUsers(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					endUserDao.deleteEndUserById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<EndUser> endUsers(int page, int limit) {
		return endUserDao.pageEndUser(page, limit);
	}
	
	public List<EndUser> list() {
		return endUserDao.listEndUser();
	}

}
