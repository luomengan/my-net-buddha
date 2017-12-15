package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.Checkin;

/**
 * 签到 Repository
 * 
 * @author luomengan
 *
 */
public interface CheckinRepository extends Repository<Checkin, Integer> {

	Checkin save(Checkin checkin);

	void delete(Integer id);

	Page<Checkin> findAll(Pageable pageable);
	
	List<Checkin> findAll();

	Checkin findById(Integer id);
	
}
