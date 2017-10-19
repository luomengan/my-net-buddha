package ${basePackage}.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${basePackage}.dao.${dataObjectPojo.name}Dao;
import ${basePackage}.entity.${dataObjectPojo.name};

/**
 * ${dataObjectPojo.description} Service
 * 
 * @author luomengan
 *
 */
@Service
public class ${dataObjectPojo.name}Service {

	@Autowired
	private ${dataObjectPojo.name}Dao ${dataObjectPojo.humpName}Dao;

	public ${dataObjectPojo.name} get${dataObjectPojo.name}Info(Integer id) {
		return ${dataObjectPojo.humpName}Dao.retrieve${dataObjectPojo.name}ById(id);
	}

	@Transactional
	public ${dataObjectPojo.name} add${dataObjectPojo.name}(${dataObjectPojo.name} ${dataObjectPojo.humpName}) {
		return ${dataObjectPojo.humpName}Dao.create${dataObjectPojo.name}(${dataObjectPojo.humpName});
	}

	@Transactional
	public ${dataObjectPojo.name} modify${dataObjectPojo.name}(${dataObjectPojo.name} ${dataObjectPojo.humpName}) {
		return ${dataObjectPojo.humpName}Dao.update${dataObjectPojo.name}(${dataObjectPojo.humpName});
	}

	@Transactional
	public void delete${dataObjectPojo.name}(Integer id) {
		${dataObjectPojo.humpName}Dao.delete${dataObjectPojo.name}ById(id);
	}
	
	@Transactional
	public void delete${dataObjectPojo.name}s(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					${dataObjectPojo.humpName}Dao.delete${dataObjectPojo.name}ById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<${dataObjectPojo.name}> ${dataObjectPojo.humpName}s(int page, int limit) {
		return ${dataObjectPojo.humpName}Dao.page${dataObjectPojo.name}(page, limit);
	}
	
	public List<${dataObjectPojo.name}> list() {
		return ${dataObjectPojo.humpName}Dao.list${dataObjectPojo.name}();
	}

}
