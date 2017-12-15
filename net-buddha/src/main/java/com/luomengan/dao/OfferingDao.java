package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.Offering;

/**
 * 供品 Dao
 * 
 * @author luomengan
 *
 */
public interface OfferingDao {

	public Offering createOffering(Offering offering);

	public void deleteOfferingById(Integer id);

	public Offering updateOffering(Offering offering);

	public Offering retrieveOfferingById(Integer id);

	public Page<Offering> pageOffering(int page, int limit);
	
	public List<Offering> listOffering();

}
