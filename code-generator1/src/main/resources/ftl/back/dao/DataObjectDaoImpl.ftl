package ${basePackage}.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import ${basePackage}.dao.${dataObjectPojo.name}Dao;
import ${basePackage}.dao.impl.jpa.${dataObjectPojo.name}Repository;
import ${basePackage}.entity.${dataObjectPojo.name};

/**
 * ${dataObjectPojo.description} Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class ${dataObjectPojo.name}DaoImpl implements ${dataObjectPojo.name}Dao {

	@Autowired
	private ${dataObjectPojo.name}Repository ${dataObjectPojo.humpName}Repository;

	@Override
	public ${dataObjectPojo.name} create${dataObjectPojo.name}(${dataObjectPojo.name} ${dataObjectPojo.humpName}) {
		return ${dataObjectPojo.humpName}Repository.save(${dataObjectPojo.humpName});
	}

	@Override
	public void delete${dataObjectPojo.name}ById(Integer id) {
		${dataObjectPojo.humpName}Repository.delete(id);
	}

	@Override
	public ${dataObjectPojo.name} update${dataObjectPojo.name}(${dataObjectPojo.name} ${dataObjectPojo.humpName}) {
		return ${dataObjectPojo.humpName}Repository.save(${dataObjectPojo.humpName});
	}

	@Override
	public ${dataObjectPojo.name} retrieve${dataObjectPojo.name}ById(Integer id) {
		return ${dataObjectPojo.humpName}Repository.findById(id);
	}

	@Override
	public Page<${dataObjectPojo.name}> page${dataObjectPojo.name}(int page, int limit) {
		return ${dataObjectPojo.humpName}Repository.findAll(new PageRequest(page, limit));
	}
	
	@Override
	public List<${dataObjectPojo.name}> list${dataObjectPojo.name}() {
		return ${dataObjectPojo.humpName}Repository.findAll();
	}

}
