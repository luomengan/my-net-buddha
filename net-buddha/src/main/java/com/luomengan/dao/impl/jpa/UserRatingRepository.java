package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.UserRating;

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
	
}
