package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.Joss;

/**
 * 佛像 Repository
 * 
 * @author luomengan
 *
 */
public interface JossRepository extends Repository<Joss, Integer> {

	Joss save(Joss joss);

	void delete(Integer id);

	Page<Joss> findAll(Pageable pageable);
	
	List<Joss> findAll();

	Joss findById(Integer id);
	
}
