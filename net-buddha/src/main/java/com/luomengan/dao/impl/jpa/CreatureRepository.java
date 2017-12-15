package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.Creature;

/**
 * 生灵 Repository
 * 
 * @author luomengan
 *
 */
public interface CreatureRepository extends Repository<Creature, Integer> {

	Creature save(Creature creature);

	void delete(Integer id);

	Page<Creature> findAll(Pageable pageable);
	
	List<Creature> findAll();

	Creature findById(Integer id);
	
}
