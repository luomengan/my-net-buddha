package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.DivinationDao;
import com.luomengan.entity.Divination;

/**
 * 灵签 Service
 * 
 * @author luomengan
 *
 */
@Service
public class DivinationService {

	@Autowired
	private DivinationDao divinationDao;

	public Divination getDivinationInfo(Integer id) {
		return divinationDao.retrieveDivinationById(id);
	}

	@Transactional
	public Divination addDivination(Divination divination) {
		return divinationDao.createDivination(divination);
	}

	@Transactional
	public Divination modifyDivination(Divination divination) {
		return divinationDao.updateDivination(divination);
	}

	@Transactional
	public void deleteDivination(Integer id) {
		divinationDao.deleteDivinationById(id);
	}
	
	@Transactional
	public void deleteDivinations(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					divinationDao.deleteDivinationById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<Divination> divinations(int page, int limit) {
		return divinationDao.pageDivination(page, limit);
	}
	
	public List<Divination> list() {
		return divinationDao.listDivination();
	}

}
