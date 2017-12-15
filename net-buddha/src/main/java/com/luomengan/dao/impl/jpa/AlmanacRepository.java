package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.Almanac;

/**
 * 黄历+佛历 Repository
 * 
 * @author luomengan
 *
 */
public interface AlmanacRepository extends Repository<Almanac, Integer> {

	Almanac save(Almanac almanac);

	void delete(Integer id);

	Page<Almanac> findAll(Pageable pageable);
	
	List<Almanac> findAll();

	Almanac findById(Integer id);
	
}
