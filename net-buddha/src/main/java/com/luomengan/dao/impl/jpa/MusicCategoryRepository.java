package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.MusicCategory;

/**
 * 佛音类别 Repository
 * 
 * @author luomengan
 *
 */
public interface MusicCategoryRepository extends Repository<MusicCategory, Integer> {

	MusicCategory save(MusicCategory musicCategory);

	void delete(Integer id);

	Page<MusicCategory> findAll(Pageable pageable);

	List<MusicCategory> findAll();

	MusicCategory findById(Integer id);

	List<MusicCategory> findByLevel(Integer level, Sort sort);

	Page<MusicCategory> findByParentId(Integer parentId, Pageable pageable);

}
