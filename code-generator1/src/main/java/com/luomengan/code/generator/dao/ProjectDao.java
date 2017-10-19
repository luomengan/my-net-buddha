package com.luomengan.code.generator.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.code.generator.entity.Project;

/**
 * 项目 Dao
 * 
 * @author luomengan
 *
 */
public interface ProjectDao {

	public Project createProject(Project project);

	public void deleteProjectById(Integer id);

	public Project updateProject(Project project);

	public Project retrieveProjectById(Integer id);

	public Page<Project> pageProject(int page, int limit);

	public List<Project> listProject();

}
