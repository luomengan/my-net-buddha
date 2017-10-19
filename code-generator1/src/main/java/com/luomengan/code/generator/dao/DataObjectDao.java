package com.luomengan.code.generator.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.code.generator.entity.DataObject;

/**
 * 数据对象 Dao
 * 
 * @author luomengan
 *
 */
public interface DataObjectDao {

	public DataObject createDataObject(DataObject dataObject);

	public void deleteDataObjectById(Integer id);

	public DataObject updateDataObject(DataObject dataObject);

	public DataObject retrieveDataObjectById(Integer id);

	public Page<DataObject> pageDataObject(int page, int limit);

	public List<DataObject> listDataObjectByProject(int projectId);

	public List<DataObject> listDataObject();

}
