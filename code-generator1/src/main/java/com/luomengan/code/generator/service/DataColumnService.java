package com.luomengan.code.generator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.code.generator.dao.DataColumnDao;
import com.luomengan.code.generator.dao.DataObjectDao;
import com.luomengan.code.generator.entity.DataColumn;
import com.luomengan.code.generator.entity.DataObject;

/**
 * 数据列 Service
 * 
 * @author luomengan
 *
 */
@Service
public class DataColumnService {

	@Autowired
	private DataColumnDao dataColumnDao;

	@Autowired
	private DataObjectDao dataObjectDao;

	public DataColumn getDataColumnInfo(Integer id) {
		return dataColumnDao.retrieveDataColumnById(id);
	}

	@Transactional
	public DataColumn addDataColumn(DataColumn dataColumn, Integer dataObjectId) {
		DataObject dataObject = dataObjectDao.retrieveDataObjectById(dataObjectId);
		if (dataObject == null) {
			throw new RuntimeException("dataObjectId无效!");
		}
		dataColumn.setDataObject(dataObject);
		return dataColumnDao.createDataColumn(dataColumn);
	}

	@Transactional
	public DataColumn modifyDataColumn(DataColumn dataColumn, Integer dataObjectId) {
		DataObject dataObject = dataObjectDao.retrieveDataObjectById(dataObjectId);
		if (dataObject == null) {
			throw new RuntimeException("dataObjectId无效!");
		}
		dataColumn.setDataObject(dataObject);
		return dataColumnDao.updateDataColumn(dataColumn);
	}

	@Transactional
	public void deleteDataColumn(Integer id) {
		dataColumnDao.deleteDataColumnById(id);
	}

	public Page<DataColumn> dataColumns(int page, int limit) {
		return dataColumnDao.pageDataColumn(page, limit);
	}

	@Transactional
	public void deleteDataColumns(String ids) {
		if (ids != null) {
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				if (!"".equals(id.trim())) {
					dataColumnDao.deleteDataColumnById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public List<DataColumn> list() {
		return dataColumnDao.listDataColumn();
	}

}
