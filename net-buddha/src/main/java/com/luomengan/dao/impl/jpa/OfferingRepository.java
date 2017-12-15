package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.Offering;

/**
 * 供品 Repository
 * 
 * @author luomengan
 *
 */
public interface OfferingRepository extends Repository<Offering, Integer> {

	Offering save(Offering offering);

	void delete(Integer id);

	Page<Offering> findAll(Pageable pageable);
	
	List<Offering> findAll();

	Offering findById(Integer id);
	
}
