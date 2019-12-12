package com.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.capp.domain.Contact;
import com.capp.rm.ContactRowMapper;
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO{

	public void save(Contact c) {
		String q = "INSERT INTO contact(userid ,name, phone, email , address , remark)"
				+ "VALUES(:userid, :name, :phone, :email , :address , :remark)";
		Map m = new HashMap();
		m.put("userid",c.getUserId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark",c.getRemark());
		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(q, ps, kh);
		Integer contactId = kh.getKey().intValue();
		c.setContactId(contactId);
	}

	public void update(Contact c) {
		String q = "update contact set " + "name=:name," + " phone=:phone," + " email=:email," + "address=:address,"
				 +"remark=:remark where contactid=:contactid";
		Map m = new HashMap();
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		m.put("contactid", c.getContactId());
		super.getNamedParameterJdbcTemplate().update(q, m);		
	}

	public void delete(Contact c) {
         		
	}

	public void deleteById(Integer contactId) {
		String q = "delete from contact where contactid=?";
		getJdbcTemplate().update(q, contactId);		
	}

	public Contact findById(Integer contactId) {
		String q = "SELECT contactid ,userid, name, phone, email, address, remark FROM contact WHERE contactid=?";
		Contact c = super.getJdbcTemplate().queryForObject(q, new ContactRowMapper(), contactId);
		return c;
	}

	public List<Contact> findAll() {
		String q = "SELECT contactid ,userid, name, phone, email, address, remark FROM contact";
		List<Contact> clist = super.getJdbcTemplate().query(q, new ContactRowMapper());
		return clist;
	}

	public List<Contact> findByProperty(String prop, Object propValue) {
		String q = "SELECT contactid ,userid, name, phone, email, address, remark FROM contact WHERE "+prop+"=?";
		return super.getJdbcTemplate().query(q, new ContactRowMapper(),propValue);
	}

}
