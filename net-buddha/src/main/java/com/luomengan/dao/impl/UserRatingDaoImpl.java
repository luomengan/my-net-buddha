package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.UserRatingDao;
import com.luomengan.dao.impl.jpa.UserRatingRepository;
import com.luomengan.entity.UserRating;

/**
 * 用户评分 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class UserRatingDaoImpl implements UserRatingDao {

	@Autowired
	private UserRatingRepository userRatingRepository;

	@Override
	public UserRating createUserRating(UserRating userRating) {
		return userRatingRepository.save(userRating);
	}

	@Override
	public void deleteUserRatingById(Integer id) {
		userRatingRepository.delete(id);
	}

	@Override
	public UserRating updateUserRating(UserRating userRating) {
		return userRatingRepository.save(userRating);
	}

	@Override
	public UserRating retrieveUserRatingById(Integer id) {
		return userRatingRepository.findById(id);
	}

	@Override
	public Page<UserRating> pageUserRating(int page, int limit) {
		return userRatingRepository.findAll(new PageRequest(page, limit));
	}
	
	@Override
	public List<UserRating> listUserRating() {
		return userRatingRepository.findAll();
	}

}
