package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.UserRating;
import com.luomengan.entity.dbenum.RatingTypeEnum;

/**
 * 用户评分 Dao
 * 
 * @author luomengan
 *
 */
public interface UserRatingDao {

	public UserRating createUserRating(UserRating userRating);

	public void deleteUserRatingById(Integer id);

	public UserRating updateUserRating(UserRating userRating);

	public UserRating retrieveUserRatingById(Integer id);

	public Page<UserRating> pageUserRating(int page, int limit);

	public List<UserRating> listUserRating();

	public List<UserRating> getUserUserRatingsByResourceId(Integer userId, RatingTypeEnum ratingType,
			Integer albumId);

}
