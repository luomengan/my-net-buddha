package com.luomengan.code.generator.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.code.generator.entity.DataColumn;
import com.luomengan.code.generator.entity.DataObject;

/**
 * 数据列 Repository
 * 
 * @author luomengan
 *
 */
public interface DataColumnRepository extends Repository<DataColumn, Integer> {

	public DataColumn save(DataColumn dataColumn);

	void delete(Integer id);

	Page<DataColumn> findAll(Pageable pageable);

	List<DataColumn> findByDataObject(DataObject dataObject);

	DataColumn findById(Integer id);

	public List<DataColumn> findAll();

}
