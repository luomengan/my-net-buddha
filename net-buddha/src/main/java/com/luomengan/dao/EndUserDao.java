package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.EndUser;

/**
 * 终端用户 Dao
 * 
 * @author luomengan
 *
 */
public interface EndUserDao {

	public EndUser createEndUser(EndUser endUser);

	public void deleteEndUserById(Integer id);

	public EndUser updateEndUser(EndUser endUser);

	public EndUser retrieveEndUserById(Integer id);
	
	public Page<EndUser> pageEndUser(int page, int limit);

	public List<EndUser> listEndUser();

	public EndUser retrieveEndUserByPhone(String phone);

}
