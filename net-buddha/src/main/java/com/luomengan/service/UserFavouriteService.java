package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.UserFavouriteDao;
import com.luomengan.entity.UserFavourite;

/**
 * 用户收藏 Service
 * 
 * @author luomengan
 *
 */
@Service
public class UserFavouriteService {

	@Autowired
	private UserFavouriteDao userFavouriteDao;

	public UserFavourite getUserFavouriteInfo(Integer id) {
		return userFavouriteDao.retrieveUserFavouriteById(id);
	}

	@Transactional
	public UserFavourite addUserFavourite(UserFavourite userFavourite) {
		return userFavouriteDao.createUserFavourite(userFavourite);
	}

	@Transactional
	public UserFavourite modifyUserFavourite(UserFavourite userFavourite) {
		return userFavouriteDao.updateUserFavourite(userFavourite);
	}

	@Transactional
	public void deleteUserFavourite(Integer id) {
		userFavouriteDao.deleteUserFavouriteById(id);
	}
	
	@Transactional
	public void deleteUserFavourites(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					userFavouriteDao.deleteUserFavouriteById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<UserFavourite> userFavourites(int page, int limit) {
		return userFavouriteDao.pageUserFavourite(page, limit);
	}
	
	public List<UserFavourite> list() {
		return userFavouriteDao.listUserFavourite();
	}

}
