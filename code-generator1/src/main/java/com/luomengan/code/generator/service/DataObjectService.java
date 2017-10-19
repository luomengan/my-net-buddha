package com.luomengan.code.generator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.code.generator.dao.DataObjectDao;
import com.luomengan.code.generator.dao.ProjectDao;
import com.luomengan.code.generator.entity.DataObject;
import com.luomengan.code.generator.entity.Project;

/**
 * 数据对象 Service
 * 
 * @author luomengan
 *
 */
@Service
public class DataObjectService {

	@Autowired
	private DataObjectDao dataObjectDao;

	@Autowired
	private ProjectDao projectDao;

	public DataObject getDataObjectInfo(Integer id) {
		return dataObjectDao.retrieveDataObjectById(id);
	}

	@Transactional
	public DataObject addDataObject(DataObject dataObject, Integer projectId) {
		Project project = projectDao.retrieveProjectById(projectId);
		if (project == null) {
			throw new RuntimeException("projectId无效!");
		}
		dataObject.setProject(project);
		return dataObjectDao.createDataObject(dataObject);
	}

	@Transactional
	public DataObject modifyDataObject(DataObject dataObject, Integer projectId) {
		Project project = projectDao.retrieveProjectById(projectId);
		if (project == null) {
			throw new RuntimeException("projectId无效!");
		}
		dataObject.setProject(project);
		return dataObjectDao.updateDataObject(dataObject);
	}

	@Transactional
	public void deleteDataObject(Integer id) {
		dataObjectDao.deleteDataObjectById(id);
	}

	public Page<DataObject> dataObjects(int page, int limit) {
		return dataObjectDao.pageDataObject(page, limit);
	}

	@Transactional
	public void deleteDataObjects(String ids) {
		if (ids != null) {
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				if (!"".equals(id.trim())) {
					dataObjectDao.deleteDataObjectById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public List<DataObject> list() {
		return dataObjectDao.listDataObject();
	}
}
