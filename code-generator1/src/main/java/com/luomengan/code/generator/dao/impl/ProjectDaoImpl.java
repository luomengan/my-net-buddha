package com.luomengan.code.generator.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.code.generator.dao.ProjectDao;
import com.luomengan.code.generator.dao.impl.jpa.ProjectRepository;
import com.luomengan.code.generator.entity.Project;

/**
 * 项目 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteProjectById(Integer id) {
		projectRepository.delete(id);
	}

	@Override
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project retrieveProjectById(Integer id) {
		return projectRepository.findById(id);
	}

	@Override
	public Page<Project> pageProject(int page, int limit) {
		return projectRepository.findAll(new PageRequest(page, limit));
	}

	@Override
	public List<Project> listProject() {
		return projectRepository.findAll();
	}

}
