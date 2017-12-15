package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.CheckinDao;
import com.luomengan.dao.impl.jpa.CheckinRepository;
import com.luomengan.entity.Checkin;

/**
 * 签到 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class CheckinDaoImpl implements CheckinDao {

	@Autowired
	private CheckinRepository checkinRepository;

	@Override
	public Checkin createCheckin(Checkin checkin) {
		return checkinRepository.save(checkin);
	}

	@Override
	public void deleteCheckinById(Integer id) {
		checkinRepository.delete(id);
	}

	@Override
	public Checkin updateCheckin(Checkin checkin) {
		return checkinRepository.save(checkin);
	}

	@Override
	public Checkin retrieveCheckinById(Integer id) {
		return checkinRepository.findById(id);
	}

	@Override
	public Page<Checkin> pageCheckin(int page, int limit) {
		return checkinRepository.findAll(new PageRequest(page, limit));
	}
	
	@Override
	public List<Checkin> listCheckin() {
		return checkinRepository.findAll();
	}

}
