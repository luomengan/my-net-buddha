package ${basePackage}.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import ${basePackage}.entity.${dataObjectPojo.name};

/**
 * ${dataObjectPojo.description} Repository
 * 
 * @author luomengan
 *
 */
public interface ${dataObjectPojo.name}Repository extends Repository<${dataObjectPojo.name}, Integer> {

	${dataObjectPojo.name} save(${dataObjectPojo.name} ${dataObjectPojo.humpName});

	void delete(Integer id);

	Page<${dataObjectPojo.name}> findAll(Pageable pageable);
	
	List<${dataObjectPojo.name}> findAll();

	${dataObjectPojo.name} findById(Integer id);
	
}
