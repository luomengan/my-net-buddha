package com.luomengan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.UserMeritWalletDao;
import com.luomengan.dao.impl.jpa.UserMeritWalletRepository;
import com.luomengan.entity.UserMeritWallet;

/**
 * 用户功德钱包 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class UserMeritWalletDaoImpl implements UserMeritWalletDao {

	@Autowired
	private UserMeritWalletRepository userMeritWalletRepository;

	@Override
	public UserMeritWallet createUserMeritWallet(UserMeritWallet userMeritWallet) {
		return userMeritWalletRepository.save(userMeritWallet);
	}

	@Override
	public void deleteUserMeritWalletById(Integer id) {
		userMeritWalletRepository.delete(id);
	}

	@Override
	public UserMeritWallet updateUserMeritWallet(UserMeritWallet userMeritWallet) {
		return userMeritWalletRepository.save(userMeritWallet);
	}

	@Override
	public UserMeritWallet retrieveUserMeritWalletById(Integer id) {
		return userMeritWalletRepository.findById(id);
	}

	@Override
	public Page<UserMeritWallet> pageUserMeritWallet(int page, int limit) {
		return userMeritWalletRepository.findAll(new PageRequest(page, limit));
	}
	
	@Override
	public List<UserMeritWallet> listUserMeritWallet() {
		return userMeritWalletRepository.findAll();
	}

	@Override
	public UserMeritWallet retrieveUserMeritWalletByUserId(Integer userId) {
		return userMeritWalletRepository.findByUserId(userId);
	}

}
