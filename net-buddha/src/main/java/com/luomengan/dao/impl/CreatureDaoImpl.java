package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.CreatureDao;
import com.luomengan.dao.impl.jpa.CreatureRepository;
import com.luomengan.entity.Creature;

/**
 * 生灵 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class CreatureDaoImpl implements CreatureDao {

	@Autowired
	private CreatureRepository creatureRepository;

	@Override
	public Creature createCreature(Creature creature) {
		return creatureRepository.save(creature);
	}

	@Override
	public void deleteCreatureById(Integer id) {
		creatureRepository.delete(id);
	}

	@Override
	public Creature updateCreature(Creature creature) {
		return creatureRepository.save(creature);
	}

	@Override
	public Creature retrieveCreatureById(Integer id) {
		return creatureRepository.findById(id);
	}

	@Override
	public Page<Creature> pageCreature(int page, int limit) {
		return creatureRepository.findAll(new PageRequest(page, limit));
	}
	
	@Override
	public List<Creature> listCreature() {
		return creatureRepository.findAll();
	}

}
