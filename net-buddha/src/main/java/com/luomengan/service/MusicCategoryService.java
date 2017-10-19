package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.MusicCategoryDao;
import com.luomengan.entity.MusicCategory;

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

	public Page<MusicCategory> pageAlbumByParentId(Integer userId, Integer parentId, Integer page, Integer limit) {
		return musicCategoryDao.pageMusicCategoryByParentId(parentId, page, limit);
	}

}
