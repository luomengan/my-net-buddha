package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.RuneDao;
import com.luomengan.entity.Rune;

/**
 * 符文 Service
 * 
 * @author luomengan
 *
 */
@Service
public class RuneService {

	@Autowired
	private RuneDao runeDao;

	public Rune getRuneInfo(Integer id) {
		return runeDao.retrieveRuneById(id);
	}

	@Transactional
	public Rune addRune(Rune rune) {
		return runeDao.createRune(rune);
	}

	@Transactional
	public Rune modifyRune(Rune rune) {
		return runeDao.updateRune(rune);
	}

	@Transactional
	public void deleteRune(Integer id) {
		runeDao.deleteRuneById(id);
	}
	
	@Transactional
	public void deleteRunes(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					runeDao.deleteRuneById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<Rune> runes(int page, int limit) {
		return runeDao.pageRune(page, limit);
	}
	
	public List<Rune> list() {
		return runeDao.listRune();
	}

}
