package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.JossDao;
import com.luomengan.entity.Joss;

/**
 * 佛像 Service
 * 
 * @author luomengan
 *
 */
@Service
public class JossService {

	@Autowired
	private JossDao jossDao;

	public Joss getJossInfo(Integer id) {
		return jossDao.retrieveJossById(id);
	}

	@Transactional
	public Joss addJoss(Joss joss) {
		return jossDao.createJoss(joss);
	}

	@Transactional
	public Joss modifyJoss(Joss joss) {
		return jossDao.updateJoss(joss);
	}

	@Transactional
	public void deleteJoss(Integer id) {
		jossDao.deleteJossById(id);
	}
	
	@Transactional
	public void deleteJosss(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					jossDao.deleteJossById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<Joss> josss(int page, int limit) {
		return jossDao.pageJoss(page, limit);
	}
	
	public List<Joss> list() {
		return jossDao.listJoss();
	}

}
