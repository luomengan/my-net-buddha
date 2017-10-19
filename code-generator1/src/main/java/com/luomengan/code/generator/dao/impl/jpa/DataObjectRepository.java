package com.luomengan.code.generator.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.code.generator.entity.DataObject;

/**
 * 数据对象 Repository
 * 
 * @author luomengan
 *
 */
public interface DataObjectRepository extends Repository<DataObject, Integer> {

	public DataObject save(DataObject dataObject);

	void delete(Integer id);

	Page<DataObject> findAll(Pageable pageable);

	DataObject findById(Integer id);

	List<DataObject> findByProjectId(Integer projectId);

	public List<DataObject> findAll();

}
