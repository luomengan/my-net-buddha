package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.Almanac;

/**
 * 黄历+佛历 Dao
 * 
 * @author luomengan
 *
 */
public interface AlmanacDao {

	public Almanac createAlmanac(Almanac almanac);

	public void deleteAlmanacById(Integer id);

	public Almanac updateAlmanac(Almanac almanac);

	public Almanac retrieveAlmanacById(Integer id);

	public Page<Almanac> pageAlmanac(int page, int limit);
	
	public List<Almanac> listAlmanac();

}
