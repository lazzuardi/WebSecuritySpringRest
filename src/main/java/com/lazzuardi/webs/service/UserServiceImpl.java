package com.lazzuardi.webs.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lazzuardi.webs.dao.UserDao;
import com.lazzuardi.webs.model.User;
import com.lazzuardi.webs.model.UserProfile;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	private static List<User> users;
	
	public List<User> findAllUsers() {
		users = dao.findAllUsers();
		return users;
	}
	
	public User findById(long id) {
		User user = dao.findById(id);
		return user;
	}
	
	public User findByName(String name) {
		User user = dao.findByName(name);
		return user;
	}
	
	public User findByEmail(String email) {
		User user = dao.findByName(email);
		return user;
	}
	
	public User findBySSO(String sso) {
		User user = dao.findBySSO(sso);
		return user;
	}
	
	public Set<UserProfile> findAllUserProfiles(long id) {
		Set<UserProfile> userProfiles = dao.findAllUserProfile(id);
		return userProfiles;
	}
	
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.saveOrUpdate(user);
	}

	public void updateUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.saveOrUpdate(user);
	}

	public void deleteUserById(long id) {
		dao.deleteById(id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}


}
