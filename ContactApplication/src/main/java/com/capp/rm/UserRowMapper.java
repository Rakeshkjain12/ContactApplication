package com.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capp.domain.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int i) throws SQLException {
        User u=new User();
        u.setUserId(rs.getInt("userid"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setAddress(rs.getString("address"));
        u.setEmail(rs.getString("email"));
        u.setLoginName(rs.getString("loginName"));
        u.setRole(rs.getInt("role"));

        u.setLoginStatus(rs.getInt("loginStatus"));
		return u;
	}

	
   
}
