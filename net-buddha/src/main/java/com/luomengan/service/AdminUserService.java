package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.AdminUserDao;
import com.luomengan.entity.AdminUser;

/**
 * 管理用户 Service
 * 
 * @author luomengan
 *
 */
@Service
public class AdminUserService {

	@Autowired
	private AdminUserDao adminUserDao;

	public AdminUser getAdminUserInfo(Integer id) {
		return adminUserDao.retrieveAdminUserById(id);
	}

	@Transactional
	public AdminUser addAdminUser(AdminUser adminUser) {
		return adminUserDao.createAdminUser(adminUser);
	}

	@Transactional
	public AdminUser modifyAdminUser(AdminUser adminUser) {
		return adminUserDao.updateAdminUser(adminUser);
	}

	@Transactional
	public void deleteAdminUser(Integer id) {
		adminUserDao.deleteAdminUserById(id);
	}
	
	@Transactional
	public void deleteAdminUsers(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					adminUserDao.deleteAdminUserById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<AdminUser> adminUsers(int page, int limit) {
		return adminUserDao.pageAdminUser(page, limit);
	}
	
	public List<AdminUser> list() {
		return adminUserDao.listAdminUser();
	}

}
