package com.luomengan.dao.impl.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luomengan.entity.UserMeritWallet;

/**
 * 用户功德钱包 Repository
 * 
 * @author luomengan
 *
 */
public interface UserMeritWalletRepository extends Repository<UserMeritWallet, Integer> {

	UserMeritWallet save(UserMeritWallet userMeritWallet);

	void delete(Integer id);

	Page<UserMeritWallet> findAll(Pageable pageable);
	
	List<UserMeritWallet> findAll();

	UserMeritWallet findById(Integer id);

	UserMeritWallet findByUserId(Integer userId);
	
}
