package com.luomengan.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luomengan.entity.UserMeritWallet;

/**
 * 用户功德钱包 Dao
 * 
 * @author luomengan
 *
 */
public interface UserMeritWalletDao {

	public UserMeritWallet createUserMeritWallet(UserMeritWallet userMeritWallet);

	public void deleteUserMeritWalletById(Integer id);

	public UserMeritWallet updateUserMeritWallet(UserMeritWallet userMeritWallet);

	public UserMeritWallet retrieveUserMeritWalletById(Integer id);

	public Page<UserMeritWallet> pageUserMeritWallet(int page, int limit);
	
	public List<UserMeritWallet> listUserMeritWallet();

	public UserMeritWallet retrieveUserMeritWalletByUserId(Integer userId);

}
