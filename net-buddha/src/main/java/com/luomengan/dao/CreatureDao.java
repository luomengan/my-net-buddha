package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.Creature;

/**
 * 生灵 Dao
 * 
 * @author luomengan
 *
 */
public interface CreatureDao {

	public Creature createCreature(Creature creature);

	public void deleteCreatureById(Integer id);

	public Creature updateCreature(Creature creature);

	public Creature retrieveCreatureById(Integer id);

	public Page<Creature> pageCreature(int page, int limit);
	
	public List<Creature> listCreature();

}
