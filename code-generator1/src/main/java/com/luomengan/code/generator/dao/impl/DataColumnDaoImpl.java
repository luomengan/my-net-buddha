package com.luomengan.code.generator.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.code.generator.dao.DataColumnDao;
import com.luomengan.code.generator.dao.impl.jpa.DataColumnRepository;
import com.luomengan.code.generator.entity.DataColumn;
import com.luomengan.code.generator.entity.DataObject;

/**
 * 数据列 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class DataColumnDaoImpl implements DataColumnDao {

	@Autowired
	private DataColumnRepository dataColumnRepository;

	@Override
	public DataColumn createDataColumn(DataColumn dataColumn) {
		return dataColumnRepository.save(dataColumn);
	}

	@Override
	public void deleteDataColumnById(Integer id) {
		dataColumnRepository.delete(id);
	}

	@Override
	public DataColumn updateDataColumn(DataColumn dataColumn) {
		return dataColumnRepository.save(dataColumn);
	}

	@Override
	public DataColumn retrieveDataColumnById(Integer id) {
		return dataColumnRepository.findById(id);
	}

	@Override
	public Page<DataColumn> pageDataColumn(int page, int limit) {
		return dataColumnRepository.findAll(new PageRequest(page, limit));
	}

	@Override
	public List<DataColumn> listDataColumnsByDataObject(DataObject dataObject) {
		return dataColumnRepository.findByDataObject(dataObject);
	}

	@Override
	public List<DataColumn> listDataColumn() {
		return dataColumnRepository.findAll();
	}

}
