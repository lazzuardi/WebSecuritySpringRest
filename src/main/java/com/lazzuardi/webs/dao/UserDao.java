package com.lazzuardi.webs.dao;

import java.util.List;
import java.util.Set;

import com.lazzuardi.webs.model.User;
import com.lazzuardi.webs.model.UserProfile;

public interface UserDao {
	
	User findById(long id);
	
	User findByName(String name);
	
	User findByEmail(String email);
	
	User findBySSO(String sso);
	
	void saveOrUpdate(User user);
	
	void deleteById(long id);
	
	List<User> findAllUsers();
	
	Set<UserProfile> findAllUserProfile(long id);

}
