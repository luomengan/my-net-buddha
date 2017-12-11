package com.luomengan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.UserFavouriteDao;
import com.luomengan.dao.impl.jpa.UserFavouriteRepository;
import com.luomengan.entity.UserFavourite;
import com.luomengan.entity.dbenum.FavouriteTypeEnum;

/**
 * 用户收藏 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class UserFavouriteDaoImpl implements UserFavouriteDao {

	@Autowired
	private UserFavouriteRepository userFavouriteRepository;

	@Override
	public UserFavourite createUserFavourite(UserFavourite userFavourite) {
		return userFavouriteRepository.save(userFavourite);
	}

	@Override
	public void deleteUserFavouriteById(Integer id) {
		userFavouriteRepository.delete(id);
	}

	@Override
	public UserFavourite updateUserFavourite(UserFavourite userFavourite) {
		return userFavouriteRepository.save(userFavourite);
	}

	@Override
	public UserFavourite retrieveUserFavouriteById(Integer id) {
		return userFavouriteRepository.findById(id);
	}

	@Override
	public Page<UserFavourite> pageUserFavourite(int page, int limit) {
		return userFavouriteRepository.findAll(new PageRequest(page, limit));
	}

	@Override
	public List<UserFavourite> listUserFavourite() {
		return userFavouriteRepository.findAll();
	}

	@Override
	public List<Integer> findResourceIdsByUserIdAndFavouriteType(Integer userId, FavouriteTypeEnum favouriteType) {
		List<Integer> result = new ArrayList<>();
		List<UserFavourite> list = userFavouriteRepository.findResourceIdsByUserIdAndFavouriteType(userId,
				favouriteType);
		if (list != null && list.size() > 0) {
			for (UserFavourite userFavourite : list) {
				result.add(userFavourite.getResourceId());
			}
		}
		return result;
	}

	@Override
	public List<UserFavourite> getUserFavouritesByResourceId(Integer userId, FavouriteTypeEnum favouriteType,
			Integer albumId) {
		Sort sort = new Sort(new Sort.Order(Direction.DESC, "favouriteTime"));
		return userFavouriteRepository.findByUserIdAndFavouriteTypeAndResourceId(userId, favouriteType, albumId, sort);
	}

}
