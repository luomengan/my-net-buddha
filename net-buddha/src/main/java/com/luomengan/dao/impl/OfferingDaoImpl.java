package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.OfferingDao;
import com.luomengan.dao.impl.jpa.OfferingRepository;
import com.luomengan.entity.Offering;

/**
 * 供品 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class OfferingDaoImpl implements OfferingDao {

	@Autowired
	private OfferingRepository offeringRepository;

	@Override
	public Offering createOffering(Offering offering) {
		return offeringRepository.save(offering);
	}

	@Override
	public void deleteOfferingById(Integer id) {
		offeringRepository.delete(id);
	}

	@Override
	public Offering updateOffering(Offering offering) {
		return offeringRepository.save(offering);
	}

	@Override
	public Offering retrieveOfferingById(Integer id) {
		return offeringRepository.findById(id);
	}

	@Override
	public Page<Offering> pageOffering(int page, int limit) {
		return offeringRepository.findAll(new PageRequest(page, limit));
	}
	
	@Override
	public List<Offering> listOffering() {
		return offeringRepository.findAll();
	}

}
