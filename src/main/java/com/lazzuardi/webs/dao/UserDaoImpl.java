/**
 * 
 */
package com.lazzuardi.webs.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lazzuardi.webs.model.User;
import com.lazzuardi.webs.model.UserProfile;
import com.lazzuardi.webs.model.UserRowMapper;

/**
 * @author Adi
 *
 */
@Component
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public User findById(long id) {
		String sql = "SELECT id, sso_id, name, email, password FROM users WHERE id = ?";
		User user = (User)jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new UserRowMapper());
		return user;
	}
	
	@Override
	public User findByName(String name) {
		String sql = "SELECT id, sso_id, name, email, password FROM users WHERE name = ?";
		User user = (User)jdbcTemplate.queryForObject(
				sql, new Object[] { name }, new UserRowMapper());
		return user;
	}
	
	@Override
	public User findByEmail(String email) {
		String sql = "SELECT id, sso_id, name, email, password FROM users WHERE email = ?";
		User user = (User)jdbcTemplate.queryForObject(
				sql, new Object[] { email }, new UserRowMapper());
		return user;
	}

	@Override
	public User findBySSO(String sso) {
		String sql = "SELECT id, sso_id, name, email, password FROM users WHERE sso_id = ?";
		User user = (User)jdbcTemplate.queryForObject(
				sql, new Object[] { sso }, new UserRowMapper());
		return user;
	}

	@Override
	public void saveOrUpdate(User user) {
		if(user.getId()>0){
	        jdbcTemplate.update("UPDATE users SET sso_id = ? , name = ? , email = ? , password = ? WHERE id = ? ",
	        		user.getSsoId(), user.getName(), user.getEmail(), user.getPassword());
		} else {
			String sqlInsert = "INSERT INTO users (sso_id, name, email, password) VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sqlInsert, user.getSsoId(), user.getName(), user.getEmail(), user.getPassword());			
		}
	}

	@Override
	public void deleteById(long id) {
        String sqlDelete = "DELETE FROM users where id=?";
        jdbcTemplate.update(sqlDelete, id);
	}

	@Override
	public List<User> findAllUsers() {
		String sql = "SELECT id, sso_id, name, email, password FROM users";
		
		List<User> users = new ArrayList<User>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			User user = new User();
			user.setId((Long)(row.get("id")));
			user.setSsoId((String)row.get("sso_id"));
			user.setName((String)row.get("name"));
			user.setEmail((String)row.get("email"));
			user.setPassword((String)row.get("password"));
			users.add(user);
		}
		return users;
	}
	
	@Override
	public Set<UserProfile> findAllUserProfile(long id) {
		String sql = "SELECT r.id, r.name, r.display_name, r.description "
				+ "FROM users u, roles r, role_user ru "
				+ "WHERE "
				+ "u.id=ru.user_id AND r.id=ru.role_id "
				+ "AND ru.user_id=?";
		
		Set<UserProfile> userProfiles = new HashSet<UserProfile>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);
		
		for (Map<String, Object> row : rows) {
			UserProfile userProfile = new UserProfile();
			userProfile.setId((Long)(row.get("id")));
			userProfile.setName((String)(row.get("name")));
			userProfile.setDisplayName((String)(row.get("display_name")));
			userProfile.setDescription((String)(row.get("description")));
			userProfiles.add(userProfile);
		}
		return userProfiles;
	}

}