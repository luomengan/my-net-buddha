package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.MusicDao;
import com.luomengan.entity.Music;

/**
 * 佛音 Service
 * 
 * @author luomengan
 *
 */
@Service
public class MusicService {

	@Autowired
	private MusicDao musicDao;

	public Music getMusicInfo(Integer id) {
		return musicDao.retrieveMusicById(id);
	}

	@Transactional
	public Music addMusic(Music music) {
		return musicDao.createMusic(music);
	}

	@Transactional
	public Music modifyMusic(Music music) {
		return musicDao.updateMusic(music);
	}

	@Transactional
	public void deleteMusic(Integer id) {
		musicDao.deleteMusicById(id);
	}

	@Transactional
	public void deleteMusics(String ids) {
		if (ids != null) {
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				if (!"".equals(id.trim())) {
					musicDao.deleteMusicById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<Music> musics(int page, int limit) {
		return musicDao.pageMusic(page, limit);
	}

	public List<Music> list() {
		return musicDao.listMusic();
	}

	public Page<Music> pageByAlbumId(Integer albumId, Integer page, Integer limit) {
		return musicDao.pageMusicByCategoryId(albumId, page, limit);
	}

}
