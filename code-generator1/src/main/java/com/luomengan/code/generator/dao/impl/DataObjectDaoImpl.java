package com.luomengan.code.generator.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.code.generator.dao.DataObjectDao;
import com.luomengan.code.generator.dao.impl.jpa.DataObjectRepository;
import com.luomengan.code.generator.entity.DataObject;

/**
 * 数据对象 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class DataObjectDaoImpl implements DataObjectDao {

	@Autowired
	private DataObjectRepository dataObjectRepository;

	@Override
	public DataObject createDataObject(DataObject dataObject) {
		return dataObjectRepository.save(dataObject);
	}

	@Override
	public void deleteDataObjectById(Integer id) {
		dataObjectRepository.delete(id);
	}

	@Override
	public DataObject updateDataObject(DataObject dataObject) {
		return dataObjectRepository.save(dataObject);
	}

	@Override
	public DataObject retrieveDataObjectById(Integer id) {
		return dataObjectRepository.findById(id);
	}

	@Override
	public Page<DataObject> pageDataObject(int page, int limit) {
		return dataObjectRepository.findAll(new PageRequest(page, limit));
	}

	@Override
	public List<DataObject> listDataObjectByProject(int projectId) {
		return dataObjectRepository.findByProjectId(projectId);
	}

	@Override
	public List<DataObject> listDataObject() {
		return dataObjectRepository.findAll();
	}

}
