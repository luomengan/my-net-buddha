package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.UserFavourite;
import com.luomengan.entity.dbenum.FavouriteTypeEnum;

/**
 * 用户收藏 Repository
 * 
 * @author luomengan
 *
 */
public interface UserFavouriteRepository extends Repository<UserFavourite, Integer> {

	UserFavourite save(UserFavourite userFavourite);

	void delete(Integer id);

	Page<UserFavourite> findAll(Pageable pageable);

	List<UserFavourite> findAll();

	UserFavourite findById(Integer id);

	@Query("from UserFavourite where userId=?1 and favouriteType=?2")
	List<UserFavourite> findResourceIdsByUserIdAndFavouriteType(Integer userId, FavouriteTypeEnum favouriteType);

	List<UserFavourite> findByUserIdAndFavouriteTypeAndResourceId(Integer userId, FavouriteTypeEnum favouriteType,
			Integer albumId, Sort sort);

}
