package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.Divination;

/**
 * 灵签 Repository
 * 
 * @author luomengan
 *
 */
public interface DivinationRepository extends Repository<Divination, Integer> {

	Divination save(Divination divination);

	void delete(Integer id);

	Page<Divination> findAll(Pageable pageable);
	
	List<Divination> findAll();

	Divination findById(Integer id);
	
}
