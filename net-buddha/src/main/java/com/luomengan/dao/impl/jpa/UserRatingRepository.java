package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.UserRating;
import com.luomengan.entity.dbenum.RatingTypeEnum;

/**
 * 用户评分 Repository
 * 
 * @author luomengan
 *
 */
public interface UserRatingRepository extends Repository<UserRating, Integer> {

	UserRating save(UserRating userRating);

	void delete(Integer id);

	Page<UserRating> findAll(Pageable pageable);
	
	List<UserRating> findAll();

	UserRating findById(Integer id);

	List<UserRating> findByUserIdAndRatingTypeAndResourceId(Integer userId, RatingTypeEnum ratingType, Integer albumId,
			Sort sort);
	
}
