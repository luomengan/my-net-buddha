package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.CreatureDao;
import com.luomengan.entity.Creature;

/**
 * 生灵 Service
 * 
 * @author luomengan
 *
 */
@Service
public class CreatureService {

	@Autowired
	private CreatureDao creatureDao;

	public Creature getCreatureInfo(Integer id) {
		return creatureDao.retrieveCreatureById(id);
	}

	@Transactional
	public Creature addCreature(Creature creature) {
		return creatureDao.createCreature(creature);
	}

	@Transactional
	public Creature modifyCreature(Creature creature) {
		return creatureDao.updateCreature(creature);
	}

	@Transactional
	public void deleteCreature(Integer id) {
		creatureDao.deleteCreatureById(id);
	}
	
	@Transactional
	public void deleteCreatures(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					creatureDao.deleteCreatureById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<Creature> creatures(int page, int limit) {
		return creatureDao.pageCreature(page, limit);
	}
	
	public List<Creature> list() {
		return creatureDao.listCreature();
	}

}
