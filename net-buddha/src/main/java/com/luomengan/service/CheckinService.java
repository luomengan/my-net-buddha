package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.CheckinDao;
import com.luomengan.entity.Checkin;

/**
 * 签到 Service
 * 
 * @author luomengan
 *
 */
@Service
public class CheckinService {

	@Autowired
	private CheckinDao checkinDao;

	public Checkin getCheckinInfo(Integer id) {
		return checkinDao.retrieveCheckinById(id);
	}

	@Transactional
	public Checkin addCheckin(Checkin checkin) {
		return checkinDao.createCheckin(checkin);
	}

	@Transactional
	public Checkin modifyCheckin(Checkin checkin) {
		return checkinDao.updateCheckin(checkin);
	}

	@Transactional
	public void deleteCheckin(Integer id) {
		checkinDao.deleteCheckinById(id);
	}
	
	@Transactional
	public void deleteCheckins(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					checkinDao.deleteCheckinById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<Checkin> checkins(int page, int limit) {
		return checkinDao.pageCheckin(page, limit);
	}
	
	public List<Checkin> list() {
		return checkinDao.listCheckin();
	}

}
