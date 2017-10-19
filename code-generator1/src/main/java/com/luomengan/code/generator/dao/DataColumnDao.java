package com.luomengan.code.generator.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.code.generator.entity.DataColumn;
import com.luomengan.code.generator.entity.DataObject;

/**
 * 数据列 Dao
 * 
 * @author luomengan
 *
 */
public interface DataColumnDao {

	public DataColumn createDataColumn(DataColumn dataColumn);

	public void deleteDataColumnById(Integer id);

	public DataColumn updateDataColumn(DataColumn dataColumn);

	public DataColumn retrieveDataColumnById(Integer id);

	public List<DataColumn> listDataColumnsByDataObject(DataObject dataObject);

	public Page<DataColumn> pageDataColumn(int page, int limit);

	public List<DataColumn> listDataColumn();

}
