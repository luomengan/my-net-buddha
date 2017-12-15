package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.AlmanacDao;
import com.luomengan.dao.impl.jpa.AlmanacRepository;
import com.luomengan.entity.Almanac;

/**
 * 黄历+佛历 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class AlmanacDaoImpl implements AlmanacDao {

	@Autowired
	private AlmanacRepository almanacRepository;

	@Override
	public Almanac createAlmanac(Almanac almanac) {
		return almanacRepository.save(almanac);
	}

	@Override
	public void deleteAlmanacById(Integer id) {
		almanacRepository.delete(id);
	}

	@Override
	public Almanac updateAlmanac(Almanac almanac) {
		return almanacRepository.save(almanac);
	}

	@Override
	public Almanac retrieveAlmanacById(Integer id) {
		return almanacRepository.findById(id);
	}

	@Override
	public Page<Almanac> pageAlmanac(int page, int limit) {
		return almanacRepository.findAll(new PageRequest(page, limit));
	}
	
	@Override
	public List<Almanac> listAlmanac() {
		return almanacRepository.findAll();
	}

}
