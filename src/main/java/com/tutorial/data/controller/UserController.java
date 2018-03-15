package com.tutorial.data.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.data.service.UserInfoService;
import com.tutorial.data.entity.UserInfo;
import com.tutorial.data.exception.UserIDNotFoundException;

@RestController
@RequestMapping("/tutorial/users")
@CrossOrigin
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserInfoService userInfoService;

	/**
	 * This method returns all the users that is available in the user_info table
	 * 
	 * @return
	 */
	@RequestMapping("/getUsers")
	public List<UserInfo> getAllUsers() {
		logger.info("Fetching all users...");
		return userInfoService.viewUsers();
	}

	/**
	 * This method returns user info based on the userid that is available in the
	 * user_info table
	 * 
	 * @return
	 */
	@RequestMapping("/getUsers/{userid}")
	public UserInfo getUsers(@PathVariable("userid") String userid) {
		logger.info("Fetching user based on userid...");
		UserInfo userInfo = userInfoService.viewUser(userid);
		if (StringUtils.isEmpty(userInfo))
			throw new UserIDNotFoundException("User Info is unavailable!!!");

		return userInfo;
	}

	/**
	 * This method inserts user info sent as a json into user_info table
	 * 
	 * @return
	 */
	@RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
	public void saveUsers(@RequestBody UserInfo userInfo) {
		logger.info("Saving multiple users...");
		userInfoService.saveUser(userInfo);
	}

	/**
	 * This method updates user info sent as a json into user_info table
	 * 
	 * @return
	 */
	@RequestMapping(value = "/saveUsers", method = RequestMethod.PUT)
	public void updateUsers(@RequestBody UserInfo userInfo) {
		logger.info("Updating an user information...");
		userInfoService.updateUser(userInfo);
	}

	/**
	 * This method deletes user info from user_info table based on userid
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deleteUser/{userid}", method = RequestMethod.DELETE)
	public void saveUsers(@PathVariable("userid") String userid) {
		logger.info("Deleting an user info...");
		userInfoService.deleteUser(userid);
	}

}
