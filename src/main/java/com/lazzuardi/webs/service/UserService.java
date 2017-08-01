package com.lazzuardi.webs.service;

import java.util.List;
import java.util.Set;

import com.lazzuardi.webs.model.User;
import com.lazzuardi.webs.model.UserProfile;


public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	User findByEmail(String email);
	
	User findBySSO(String sso);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers();
	
	Set<UserProfile> findAllUserProfiles(long id);
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
