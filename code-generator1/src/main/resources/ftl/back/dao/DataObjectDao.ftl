package ${basePackage}.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import ${basePackage}.entity.${dataObjectPojo.name};

/**
 * ${dataObjectPojo.description} Dao
 * 
 * @author luomengan
 *
 */
public interface ${dataObjectPojo.name}Dao {

	public ${dataObjectPojo.name} create${dataObjectPojo.name}(${dataObjectPojo.name} ${dataObjectPojo.humpName});

	public void delete${dataObjectPojo.name}ById(Integer id);

	public ${dataObjectPojo.name} update${dataObjectPojo.name}(${dataObjectPojo.name} ${dataObjectPojo.humpName});

	public ${dataObjectPojo.name} retrieve${dataObjectPojo.name}ById(Integer id);

	public Page<${dataObjectPojo.name}> page${dataObjectPojo.name}(int page, int limit);
	
	public List<${dataObjectPojo.name}> list${dataObjectPojo.name}();

}
