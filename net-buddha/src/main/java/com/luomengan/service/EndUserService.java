package com.luomengan.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.luomengan.dao.EndUserDao;
import com.luomengan.dao.UserMeritFlowDao;
import com.luomengan.dao.UserMeritWalletDao;
import com.luomengan.entity.EndUser;
import com.luomengan.entity.UserMeritWallet;
import com.luomengan.entity.dbenum.GenderEnum;
import com.luomengan.exception.ExceptionEnum;
import com.luomengan.exception.ServiceException;

/**
 * 终端用户 Service
 * 
 * @author luomengan
 *
 */
@Service
public class EndUserService {

	@Autowired
	private EndUserDao endUserDao;

	@Autowired
	private UserMeritWalletDao userMeritWalletDao;
	
	@Autowired
	private UserMeritFlowDao userMeritFlowDao;

	@Value("${custom.outer.resources}")
	private String outerResources;

	@Value("${custom.outer.serverUrl}")
	private String serverUrl;

	public EndUser getEndUserInfo(Integer id) {
		return endUserDao.retrieveEndUserById(id);
	}

	@Transactional
	public EndUser addEndUser(EndUser endUser) {
		return endUserDao.createEndUser(endUser);
	}

	@Transactional
	public EndUser modifyEndUser(EndUser endUser) {
		endUser.setUpdateTime(new Date());
		return endUserDao.updateEndUser(endUser);
	}

	@Transactional
	public void deleteEndUser(Integer id) {
		endUserDao.deleteEndUserById(id);
	}

	@Transactional
	public void deleteEndUsers(String ids) {
		if (ids != null) {
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				if (!"".equals(id.trim())) {
					endUserDao.deleteEndUserById(Integer.parseInt(id.trim()));
				}
			}
		}
	}

	public Page<EndUser> endUsers(int page, int limit) {
		return endUserDao.pageEndUser(page, limit);
	}

	public List<EndUser> list() {
		return endUserDao.listEndUser();
	}

	public String uploadHeadPortrait(Integer userId, MultipartFile file) {
		EndUser endUser = endUserDao.retrieveEndUserById(userId);

		File headPortraitDir = new File(outerResources + "headPortrait");
		if (!headPortraitDir.exists()) {
			headPortraitDir.mkdirs();
		}
		String contentType = file.getContentType();
		String suffix = ".png";
		if (contentType.contains("png")) {
			suffix = ".png";
		} else if (contentType.contains("jpeg")) {
			suffix = ".jpg";
		} else {
			throw new ServiceException(ExceptionEnum.UnsupportedPictureFormat_Exception);
		}
		String fileName = System.currentTimeMillis() + suffix;
		File headPortraitFile = new File(headPortraitDir, fileName);

		InputStream in = null;
		OutputStream out = null;
		try {
			in = file.getInputStream();
			out = new FileOutputStream(headPortraitFile);
			IOUtils.copy(in, out);
			String headPortraitLink = serverUrl + "headPortrait/" + fileName;
			endUser.setHeadPortraitLink(headPortraitLink);
			endUserDao.updateEndUser(endUser);
			return headPortraitLink;
		} catch (IOException e) {
			throw new ServiceException(ExceptionEnum.Unknow_Exception, "IO操作异常");
		}
	}

	public Integer getUserMeritValue(Integer userId) {
		UserMeritWallet wallet = userMeritWalletDao.retrieveUserMeritWalletByUserId(userId);
		if (wallet == null) {
			wallet = new UserMeritWallet();
			wallet.setMeritValue(0);
			wallet.setUserId(userId);
			wallet.setUpdateTime(new Date());
			userMeritWalletDao.createUserMeritWallet(wallet);
		}
		return wallet.getMeritValue();
	}

	public Integer getUserConsumeMerit(Integer userId) {
		return userMeritFlowDao.retriveUserConsumeMerit(userId);
	}

	public EndUser register(String phone, String password) {
		EndUser endUser = endUserDao.retrieveEndUserByPhone(phone);
		if (endUser != null) {
			throw new ServiceException(ExceptionEnum.PhoneAlreadyRegister_Exception);
		}

		endUser = new EndUser();
		endUser.setPhone(phone);
		endUser.setPassword(password);
		endUser.setGender(GenderEnum.Man);
		endUser.setCreateTime(new Date());
		endUserDao.createEndUser(endUser);
		return endUser;
	}

}
