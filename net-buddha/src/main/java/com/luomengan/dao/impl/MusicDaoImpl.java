package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.MusicDao;
import com.luomengan.dao.impl.jpa.MusicRepository;
import com.luomengan.entity.Music;

/**
 * 佛音 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class MusicDaoImpl implements MusicDao {

	@Autowired
	private MusicRepository musicRepository;

	@Override
	public Music createMusic(Music music) {
		return musicRepository.save(music);
	}

	@Override
	public void deleteMusicById(Integer id) {
		musicRepository.delete(id);
	}

	@Override
	public Music updateMusic(Music music) {
		return musicRepository.save(music);
	}

	@Override
	public Music retrieveMusicById(Integer id) {
		return musicRepository.findById(id);
	}

	@Override
	public Page<Music> pageMusic(int page, int limit) {
		return musicRepository.findAll(new PageRequest(page, limit));
	}

	@Override
	public List<Music> listMusic() {
		return musicRepository.findAll();
	}

	@Override
	public Page<Music> pageMusicByCategoryId(Integer categoryId, Integer page, Integer limit) {
		Sort sort = new Sort(new Sort.Order(Direction.DESC, "sortNum"));
		Pageable pageable = new PageRequest(page, limit, sort);
		return musicRepository.findByCategoryId(categoryId, pageable);
	}

}
