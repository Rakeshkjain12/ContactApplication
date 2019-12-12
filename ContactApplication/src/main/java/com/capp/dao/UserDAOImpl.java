package com.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.capp.domain.User;
import com.capp.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	public void save(User u) {
		String q = "INSERT INTO user(name, phone, email , address , loginName , password , role , loginStatus)"
				+ "VALUES(:name, :phone, :email , :address , :loginName , :password , :role , :loginStatus)";
		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());

		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(q, ps, kh);
		Integer userId = kh.getKey().intValue();
		u.setUserId(userId);
	}

	public int update(User u) {
		
		
		
	
		String q = "update user set " + "name=:name," + " phone=:phone," + " email=:email," + "address=:address,"
				+ "role=:role," + "loginStatus=:loginStatus " + "where userid=:userId AND password=:pw";
		
		System.out.println(u.getName());
		System.out.println(u.getPhone());
		System.out.println(u.getEmail());
		System.out.println(u.getAddress());
		System.out.println(u.getRole());
		System.out.println(u.getLoginStatus());
		System.out.println(u.getUserId());
		System.out.println(u.getPassword());
		
		
		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		m.put("userId", u.getUserId());
        m.put("pw",u.getPassword());
		int res=super.getNamedParameterJdbcTemplate().update(q, m);
		System.out.println(res);
		return res;
	}

	public void delete(User u) {
		this.deleteById(u.getUserId());
	}

	public void deleteById(Integer userId) {
		String q = "delete from user where userid=?";
		getJdbcTemplate().update(q, userId);
	}

	public User findById(Integer userId) {
		String q = "SELECT userid, name, phone, email, address, loginName, role, loginStatus FROM user WHERE userid=?";
		User u = super.getJdbcTemplate().queryForObject(q, new UserRowMapper(), userId);
		return u;
	}

	public List<User> findAll() {
		String q = "SELECT userid, name, phone, email, address, loginName, role, loginStatus FROM user";
		List<User> users = super.getJdbcTemplate().query(q, new UserRowMapper());
		return users;
	}

	public List<User> findByProperty(String prop, Object propValue) { 
		String q = "SELECT userid, name, phone, email, address, loginName, role, loginStatus FROM user WHERE "+prop+"=?";
		return super.getJdbcTemplate().query(q, new UserRowMapper(),propValue);
	}

	
}
