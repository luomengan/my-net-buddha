package com.luomengan.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.MusicCategoryDao;
import com.luomengan.dao.UserFavouriteDao;
import com.luomengan.dao.UserRatingDao;
import com.luomengan.entity.MusicCategory;
import com.luomengan.entity.UserFavourite;
import com.luomengan.entity.UserRating;
import com.luomengan.entity.dbenum.FavouriteTypeEnum;
import com.luomengan.entity.dbenum.RatingTypeEnum;
import com.luomengan.exception.ExceptionEnum;
import com.luomengan.exception.ServiceException;
import com.luomengan.pojo.MusicCategoryInfo;

/**
 * 佛音类别 Service
 * 
 * @author luomengan
 *
 */
@Service
public class MusicCategoryService {

	@Autowired
	private MusicCategoryDao musicCategoryDao;

	@Autowired
	private UserFavouriteDao userFavouriteDao;

	@Autowired
	private UserRatingDao userRatingDao;

	public MusicCategory getMusicCategoryInfo(Integer id) {
		return musicCategoryDao.retrieveMusicCategoryById(id);
	}

	@Transactional
	public MusicCategory addMusicCategory(MusicCategory musicCategory) {
		return musicCategoryDao.createMusicCategory(musicCategory);
	}

	@Transactional
	public MusicCategory modifyMusicCategory(MusicCategory musicCategory) {
		return musicCategoryDao.updateMusicCategory(musicCategory);
	}

	@Transactional
	public void deleteMusicCategory(Integer id) {
		musicCategoryDao.deleteMusicCategoryById(id);
	}

	@Transactional
	public void deleteMusicCategorys(String ids) {
		if (ids != null) {
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				if (!"".equals(id.trim())) {
					musicCategoryDao.deleteMusicCategoryById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<MusicCategory> musicCategorys(int page, int limit) {
		return musicCategoryDao.pageMusicCategory(page, limit);
	}

	public List<MusicCategory> list() {
		return musicCategoryDao.listMusicCategory();
	}

	public List<MusicCategory> listTopCategory() {
		return musicCategoryDao.listMusicCategoryByLevel(1);
	}

	public Page<MusicCategoryInfo> pageAlbumByParentId(Integer currentUserId, Integer parentId, Integer page,
			Integer limit) {
		Page<MusicCategoryInfo> result = musicCategoryDao.sqlPageMusicCategoryByParentId(parentId, page, limit);
		if (result.getContent() != null && result.getContent().size() > 0) {
			List<Integer> resourceIds = userFavouriteDao.findResourceIdsByUserIdAndFavouriteType(currentUserId,
					FavouriteTypeEnum.MusicCategory);
			if (resourceIds != null && resourceIds.size() > 0) {
				for (MusicCategoryInfo category : result.getContent()) {
					if (resourceIds.contains(category.getId())) {
						category.setCurrentUserFavourite(true);
					}
				}
			}
		}
		return result;
	}

	public UserFavourite userFavourite(Integer userId, Integer albumId) {
		List<UserFavourite> list = userFavouriteDao.getUserFavouritesByResourceId(userId,
				FavouriteTypeEnum.MusicCategory, albumId);
		if (list != null && list.size() > 0) {
			throw new ServiceException(ExceptionEnum.AlreadyFavourite_Exception);
		}
		UserFavourite userFavourite = new UserFavourite();
		userFavourite.setFavouriteTime(new Date());
		userFavourite.setResourceId(albumId);
		userFavourite.setFavouriteType(FavouriteTypeEnum.MusicCategory);
		userFavourite.setUserId(userId);
		return userFavouriteDao.createUserFavourite(userFavourite);
	}

	public UserRating userRating(Integer userId, Integer albumId, double rating) {
		List<UserRating> list = userRatingDao.getUserUserRatingsByResourceId(userId,
				RatingTypeEnum.MusicCategory, albumId);
		if (list != null && list.size() > 0) {
			throw new ServiceException(ExceptionEnum.AlreadyRating_Exception);
		}
		UserRating userRating = new UserRating();
		userRating.setRatingTime(new Date());
		userRating.setResourceId(albumId);
		userRating.setRatingType(RatingTypeEnum.MusicCategory);
		userRating.setUserId(userId);
		userRating.setRating(rating);
		return userRatingDao.createUserRating(userRating);
	}

}
