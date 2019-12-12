package com.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capp.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact>{

	public Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact c=new Contact();
        c.setContactId(rs.getInt("contactid"));
        c.setUserId(rs.getInt("userid"));
        c.setName(rs.getString("name"));
        c.setPhone(rs.getString("phone"));
        c.setAddress(rs.getString("address"));
        c.setEmail(rs.getString("email"));
        c.setRemark(rs.getString("remark"));
   
		return c;
	}

	
   
}
