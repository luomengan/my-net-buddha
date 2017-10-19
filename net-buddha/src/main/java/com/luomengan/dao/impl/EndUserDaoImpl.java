package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.EndUserDao;
import com.luomengan.dao.impl.jpa.EndUserRepository;
import com.luomengan.entity.EndUser;

/**
 * 终端用户 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class EndUserDaoImpl implements EndUserDao {

	@Autowired
	private EndUserRepository endUserRepository;

	@Override
	public EndUser createEndUser(EndUser endUser) {
		return endUserRepository.save(endUser);
	}

	@Override
	public void deleteEndUserById(Integer id) {
		endUserRepository.delete(id);
	}

	@Override
	public EndUser updateEndUser(EndUser endUser) {
		return endUserRepository.save(endUser);
	}

	@Override
	public EndUser retrieveEndUserById(Integer id) {
		return endUserRepository.findById(id);
	}

	@Override
	public Page<EndUser> pageEndUser(int page, int limit) {
		return endUserRepository.findAll(new PageRequest(page, limit));
	}

	@Override
	public List<EndUser> listEndUser() {
		return endUserRepository.findAll();
	}

	@Override
	public EndUser retrieveEndUserByPhone(String phone) {
		return endUserRepository.findByPhone(phone);
	}

}
