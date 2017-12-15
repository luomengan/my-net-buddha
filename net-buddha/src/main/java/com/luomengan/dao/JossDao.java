package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.Joss;

/**
 * 佛像 Dao
 * 
 * @author luomengan
 *
 */
public interface JossDao {

	public Joss createJoss(Joss joss);

	public void deleteJossById(Integer id);

	public Joss updateJoss(Joss joss);

	public Joss retrieveJossById(Integer id);

	public Page<Joss> pageJoss(int page, int limit);
	
	public List<Joss> listJoss();

}
