package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.OfferingDao;
import com.luomengan.entity.Offering;

/**
 * 供品 Service
 * 
 * @author luomengan
 *
 */
@Service
public class OfferingService {

	@Autowired
	private OfferingDao offeringDao;

	public Offering getOfferingInfo(Integer id) {
		return offeringDao.retrieveOfferingById(id);
	}

	@Transactional
	public Offering addOffering(Offering offering) {
		return offeringDao.createOffering(offering);
	}

	@Transactional
	public Offering modifyOffering(Offering offering) {
		return offeringDao.updateOffering(offering);
	}

	@Transactional
	public void deleteOffering(Integer id) {
		offeringDao.deleteOfferingById(id);
	}
	
	@Transactional
	public void deleteOfferings(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					offeringDao.deleteOfferingById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<Offering> offerings(int page, int limit) {
		return offeringDao.pageOffering(page, limit);
	}
	
	public List<Offering> list() {
		return offeringDao.listOffering();
	}

}
