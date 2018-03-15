/**
 * 
 */
package com.tutorial.data.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.data.entity.UserInfo;
import com.tutorial.data.repository.UserInfoRepository;

/**
 * @author Jafer
 *
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{
	
	/**
	 * Logger to show info
	 */
	private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	/**
	 * Dependency Injection for userInfoRepository
	 */
	@Autowired
	UserInfoRepository userInfoRepository;
	
	/**
	 * Fetch list of users 
	 */
	@Override
	public List<UserInfo> viewUsers() {
		logger.info("Fetching all users...");
		List<UserInfo> agentList = userInfoRepository.findAll();
		return agentList;
	}

	/**
	 * Insert an user information to table
	 */
	@Override
	public void saveUser(UserInfo userInfo) {
		logger.info("Fetching user based on userid...");
		userInfoRepository.save(userInfo);	
	}

	/**
	 * View user information based on userid
	 */
	@Override
	public UserInfo viewUser(String userid) {
		logger.info("Viewing an user based on userid...");
		UserInfo userInfo = userInfoRepository.findOne(userid);
		return userInfo;
	}

	/**
	 * Update an user by passing userInfo object
	 */
	@Override
	public void updateUser(UserInfo userInfo) {
		logger.info("Updating an user info...");
		userInfoRepository.save(userInfo);	
	}
	
	/**
	 * Deleting an user based on userId
	 */
	@Override
	public void deleteUser(String id) {
		logger.info("Deleting an user based on id...");
		userInfoRepository.delete(id);
	}
}
