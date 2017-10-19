package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.Music;

/**
 * 佛音 Dao
 * 
 * @author luomengan
 *
 */
public interface MusicDao {

	public Music createMusic(Music music);

	public void deleteMusicById(Integer id);

	public Music updateMusic(Music music);

	public Music retrieveMusicById(Integer id);

	public Page<Music> pageMusic(int page, int limit);

	public List<Music> listMusic();

	public Page<Music> pageMusicByCategoryId(Integer categoryId, Integer page, Integer limit);

}
