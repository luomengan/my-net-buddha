package com.luomengan.code.generator.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.code.generator.entity.Project;

/**
 * 项目 Repository
 * 
 * @author luomengan
 *
 */
public interface ProjectRepository extends Repository<Project, Integer> {

	public Project save(Project project);

	void delete(Integer id);

	Page<Project> findAll(Pageable pageable);

	Project findById(Integer id);

	public List<Project> findAll();
	
}
