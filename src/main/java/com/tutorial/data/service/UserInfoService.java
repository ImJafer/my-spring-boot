/**
 * 
 */
package com.tutorial.data.service;

import java.util.List;

import com.tutorial.data.entity.UserInfo;

/**
 * @author Jafer
 *
 */
public interface UserInfoService {
	
	/**
	 * Viewing all the users form the table
	 * @return
	 */
	List<UserInfo> viewUsers();
	
	/**
	 * Viewing the information of a particular user by userId
	 * @param id
	 * @return
	 */
	UserInfo viewUser(String id);
	
	/**
	 * Saving an user information
	 * @param userInfo
	 */
	void saveUser(UserInfo userInfo);
	
	/**
	 * Deleting an user based on the user id
	 * @param id
	 */
	void deleteUser(String id);
	
	/**
	 * Update the user to the table
	 * @param userInfo
	 */
	void updateUser(UserInfo userInfo);
}
