package com.luomengan.code.generator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.code.generator.dao.ProjectDao;
import com.luomengan.code.generator.entity.Project;

/**
 * 项目 Service
 * 
 * @author luomengan
 *
 */
@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public Project getProjectInfo(Integer id) {
		return projectDao.retrieveProjectById(id);
	}

	@Transactional
	public Project addProject(Project project) {
		return projectDao.createProject(project);
	}

	@Transactional
	public Project modifyProject(Project project) {
		return projectDao.updateProject(project);
	}

	@Transactional
	public void deleteProject(Integer id) {
		projectDao.deleteProjectById(id);
	}

	public Page<Project> projects(int page, int limit) {
		return projectDao.pageProject(page, limit);
	}

	@Transactional
	public void deleteProjects(String ids) {
		if (ids != null) {
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				if (!"".equals(id.trim())) {
					projectDao.deleteProjectById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public List<Project> list() {
		return projectDao.listProject();
	}

}
