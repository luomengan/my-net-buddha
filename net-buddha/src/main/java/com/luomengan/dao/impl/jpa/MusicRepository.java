package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.Music;

/**
 * 佛音 Repository
 * 
 * @author luomengan
 *
 */
public interface MusicRepository extends Repository<Music, Integer> {

	Music save(Music music);

	void delete(Integer id);

	Page<Music> findAll(Pageable pageable);

	List<Music> findAll();

	Music findById(Integer id);

	Page<Music> findByCategoryId(Integer categoryId, Pageable pageable);

}
