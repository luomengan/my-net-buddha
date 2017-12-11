package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.UserFavourite;
import com.luomengan.entity.dbenum.FavouriteTypeEnum;

/**
 * 用户收藏 Dao
 * 
 * @author luomengan
 *
 */
public interface UserFavouriteDao {

	public UserFavourite createUserFavourite(UserFavourite userFavourite);

	public void deleteUserFavouriteById(Integer id);

	public UserFavourite updateUserFavourite(UserFavourite userFavourite);

	public UserFavourite retrieveUserFavouriteById(Integer id);

	public Page<UserFavourite> pageUserFavourite(int page, int limit);

	public List<UserFavourite> listUserFavourite();

	public List<Integer> findResourceIdsByUserIdAndFavouriteType(Integer userId, FavouriteTypeEnum favouriteType);

	public List<UserFavourite> getUserFavouritesByResourceId(Integer userId, FavouriteTypeEnum musiccategory,
			Integer albumId);

}
