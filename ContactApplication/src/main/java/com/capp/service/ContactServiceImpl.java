package com.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capp.dao.BaseDAO;
import com.capp.dao.ContactDAO;
import com.capp.domain.Contact;
import com.capp.rm.ContactRowMapper;
import com.capp.util.StringUtil;
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {
    @Autowired
	private ContactDAO cdao;
	public void save(Contact c) {
         cdao.save(c);		
	}

	public void update(Contact c) {
         cdao.update(c);		
	}

	public void delete(Integer contactId) {
           cdao.deleteById(contactId);		
	}

	public void delete(Integer[] contactIds) {
		String ids=StringUtil.toCommaSeparatedString(contactIds);
        String q="DELETE FROM contact WHERE contactid IN("+ids+")";
        super.getJdbcTemplate().update(q);
	}

	public List<Contact> findUserContact(Integer userId) {
		return cdao.findByProperty("userid", userId );
	}

	public List<Contact> findUserContact(Integer userId, String txt) {
		String q = "SELECT contactid ,userid, name, phone, email, address, remark FROM contact WHERE userid = ? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
		List<Contact> clist = super.getJdbcTemplate().query(q, new ContactRowMapper() ,userId);
		return clist;
	}

	public Contact findContactById(Integer contactId) {
		return cdao.findById(contactId);
	}

}
