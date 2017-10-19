package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.UserRatingDao;
import com.luomengan.entity.UserRating;

/**
 * 用户评分 Service
 * 
 * @author luomengan
 *
 */
@Service
public class UserRatingService {

	@Autowired
	private UserRatingDao userRatingDao;

	public UserRating getUserRatingInfo(Integer id) {
		return userRatingDao.retrieveUserRatingById(id);
	}

	@Transactional
	public UserRating addUserRating(UserRating userRating) {
		return userRatingDao.createUserRating(userRating);
	}

	@Transactional
	public UserRating modifyUserRating(UserRating userRating) {
		return userRatingDao.updateUserRating(userRating);
	}

	@Transactional
	public void deleteUserRating(Integer id) {
		userRatingDao.deleteUserRatingById(id);
	}
	
	@Transactional
	public void deleteUserRatings(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					userRatingDao.deleteUserRatingById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<UserRating> userRatings(int page, int limit) {
		return userRatingDao.pageUserRating(page, limit);
	}
	
	public List<UserRating> list() {
		return userRatingDao.listUserRating();
	}

}
