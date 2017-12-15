package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.AlmanacDao;
import com.luomengan.entity.Almanac;

/**
 * 黄历+佛历 Service
 * 
 * @author luomengan
 *
 */
@Service
public class AlmanacService {

	@Autowired
	private AlmanacDao almanacDao;

	public Almanac getAlmanacInfo(Integer id) {
		return almanacDao.retrieveAlmanacById(id);
	}

	@Transactional
	public Almanac addAlmanac(Almanac almanac) {
		return almanacDao.createAlmanac(almanac);
	}

	@Transactional
	public Almanac modifyAlmanac(Almanac almanac) {
		return almanacDao.updateAlmanac(almanac);
	}

	@Transactional
	public void deleteAlmanac(Integer id) {
		almanacDao.deleteAlmanacById(id);
	}
	
	@Transactional
	public void deleteAlmanacs(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					almanacDao.deleteAlmanacById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<Almanac> almanacs(int page, int limit) {
		return almanacDao.pageAlmanac(page, limit);
	}
	
	public List<Almanac> list() {
		return almanacDao.listAlmanac();
	}

}
