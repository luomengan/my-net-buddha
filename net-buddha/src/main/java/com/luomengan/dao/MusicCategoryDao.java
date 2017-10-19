package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.MusicCategory;

/**
 * 佛音类别 Dao
 * 
 * @author luomengan
 *
 */
public interface MusicCategoryDao {

	public MusicCategory createMusicCategory(MusicCategory musicCategory);

	public void deleteMusicCategoryById(Integer id);

	public MusicCategory updateMusicCategory(MusicCategory musicCategory);

	public MusicCategory retrieveMusicCategoryById(Integer id);

	public Page<MusicCategory> pageMusicCategory(int page, int limit);

	public List<MusicCategory> listMusicCategory();

	public List<MusicCategory> listMusicCategoryByLevel(Integer level);

	public Page<MusicCategory> pageMusicCategoryByParentId(Integer parentId, Integer page, Integer limit);

}
