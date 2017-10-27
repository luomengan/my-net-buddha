package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.UserMeritFlow;

/**
 * 用户功德流水 Repository
 * 
 * @author luomengan
 *
 */
public interface UserMeritFlowRepository extends Repository<UserMeritFlow, Integer> {

	UserMeritFlow save(UserMeritFlow userMeritFlow);

	void delete(Integer id);

	Page<UserMeritFlow> findAll(Pageable pageable);
	
	List<UserMeritFlow> findAll();

	UserMeritFlow findById(Integer id);
	
}
