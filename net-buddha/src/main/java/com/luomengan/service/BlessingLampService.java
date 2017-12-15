package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.BlessingLampDao;
import com.luomengan.entity.BlessingLamp;

/**
 * 祈福明灯 Service
 * 
 * @author luomengan
 *
 */
@Service
public class BlessingLampService {

	@Autowired
	private BlessingLampDao blessingLampDao;

	public BlessingLamp getBlessingLampInfo(Integer id) {
		return blessingLampDao.retrieveBlessingLampById(id);
	}

	@Transactional
	public BlessingLamp addBlessingLamp(BlessingLamp blessingLamp) {
		return blessingLampDao.createBlessingLamp(blessingLamp);
	}

	@Transactional
	public BlessingLamp modifyBlessingLamp(BlessingLamp blessingLamp) {
		return blessingLampDao.updateBlessingLamp(blessingLamp);
	}

	@Transactional
	public void deleteBlessingLamp(Integer id) {
		blessingLampDao.deleteBlessingLampById(id);
	}
	
	@Transactional
	public void deleteBlessingLamps(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					blessingLampDao.deleteBlessingLampById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<BlessingLamp> blessingLamps(int page, int limit) {
		return blessingLampDao.pageBlessingLamp(page, limit);
	}
	
	public List<BlessingLamp> list() {
		return blessingLampDao.listBlessingLamp();
	}

}
