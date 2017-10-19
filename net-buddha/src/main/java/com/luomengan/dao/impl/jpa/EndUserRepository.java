package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.EndUser;

/**
 * 终端用户 Repository
 * 
 * @author luomengan
 *
 */
public interface EndUserRepository extends Repository<EndUser, Integer> {

	EndUser save(EndUser endUser);

	void delete(Integer id);

	Page<EndUser> findAll(Pageable pageable);

	List<EndUser> findAll();

	EndUser findById(Integer id);

	EndUser findByPhone(String phone);

}
