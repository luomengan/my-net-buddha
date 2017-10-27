package com.luomengan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luomengan.dao.UserMeritWalletDao;
import com.luomengan.entity.UserMeritWallet;

/**
 * 用户功德钱包 Service
 * 
 * @author luomengan
 *
 */
@Service
public class UserMeritWalletService {

	@Autowired
	private UserMeritWalletDao userMeritWalletDao;

	public UserMeritWallet getUserMeritWalletInfo(Integer id) {
		return userMeritWalletDao.retrieveUserMeritWalletById(id);
	}

	@Transactional
	public UserMeritWallet addUserMeritWallet(UserMeritWallet userMeritWallet) {
		return userMeritWalletDao.createUserMeritWallet(userMeritWallet);
	}

	@Transactional
	public UserMeritWallet modifyUserMeritWallet(UserMeritWallet userMeritWallet) {
		return userMeritWalletDao.updateUserMeritWallet(userMeritWallet);
	}

	@Transactional
	public void deleteUserMeritWallet(Integer id) {
		userMeritWalletDao.deleteUserMeritWalletById(id);
	}
	
	@Transactional
	public void deleteUserMeritWallets(String ids) {
		if(ids != null) {
			String[] idArr= ids.split(",");
			for(String id : idArr) {
				if(!"".equals(id.trim())) {
					userMeritWalletDao.deleteUserMeritWalletById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<UserMeritWallet> userMeritWallets(int page, int limit) {
		return userMeritWalletDao.pageUserMeritWallet(page, limit);
	}
	
	public List<UserMeritWallet> list() {
		return userMeritWalletDao.listUserMeritWallet();
	}

}
