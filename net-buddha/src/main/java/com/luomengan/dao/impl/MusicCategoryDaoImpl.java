package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.MusicCategoryDao;
import com.luomengan.dao.impl.jpa.MusicCategoryRepository;
import com.luomengan.entity.MusicCategory;

/**
 * 佛音类别 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class MusicCategoryDaoImpl implements MusicCategoryDao {

	@Autowired
	private MusicCategoryRepository musicCategoryRepository;

	@Override
	public MusicCategory createMusicCategory(MusicCategory musicCategory) {
		return musicCategoryRepository.save(musicCategory);
	}

	@Override
	public void deleteMusicCategoryById(Integer id) {
		musicCategoryRepository.delete(id);
	}

	@Override
	public MusicCategory updateMusicCategory(MusicCategory musicCategory) {
		return musicCategoryRepository.save(musicCategory);
	}

	@Override
	public MusicCategory retrieveMusicCategoryById(Integer id) {
		return musicCategoryRepository.findById(id);
	}

	@Override
	public Page<MusicCategory> pageMusicCategory(int page, int limit) {
		return musicCategoryRepository.findAll(new PageRequest(page, limit));
	}

	@Override
	public List<MusicCategory> listMusicCategory() {
		return musicCategoryRepository.findAll();
	}

	@Override
	public List<MusicCategory> listMusicCategoryByLevel(Integer level) {
		Sort sort = new Sort(new Sort.Order(Direction.DESC, "sortNum"));
		return musicCategoryRepository.findByLevel(level, sort);
	}

	@Override
	public Page<MusicCategory> pageMusicCategoryByParentId(Integer parentId, Integer page, Integer limit) {
		Sort sort = new Sort(new Sort.Order(Direction.DESC, "sortNum"));
		Pageable pageable = new PageRequest(page, limit, sort);
		return musicCategoryRepository.findByParentId(parentId, pageable);
	}

}
