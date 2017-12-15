package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.BlessingLamp;

/**
 * 祈福明灯 Dao
 * 
 * @author luomengan
 *
 */
public interface BlessingLampDao {

	public BlessingLamp createBlessingLamp(BlessingLamp blessingLamp);

	public void deleteBlessingLampById(Integer id);

	public BlessingLamp updateBlessingLamp(BlessingLamp blessingLamp);

	public BlessingLamp retrieveBlessingLampById(Integer id);

	public Page<BlessingLamp> pageBlessingLamp(int page, int limit);
	
	public List<BlessingLamp> listBlessingLamp();

}
