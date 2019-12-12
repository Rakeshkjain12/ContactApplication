package com.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.capp.dao.BaseDAO;
import com.capp.dao.UserDAO;
import com.capp.domain.User;
import com.capp.exception.UserBlockException;
import com.capp.rm.UserRowMapper;
@Service
public class UserServiceImpl extends BaseDAO implements UserService  {
    
	@Autowired
	private UserDAO userDAO;

	public void register(User u) {
            userDAO.save(u);
	}

	public User login(String loginName, String password) throws UserBlockException {
        String q="SELECT userid, name, phone, email, address, loginName, role, loginStatus"
        		+ " FROM user WHERE loginName=:ln AND password=:pw";
        Map m=new HashMap();
        m.put("ln", loginName);
        m.put("pw", password);
        try {
            User u= super.getNamedParameterJdbcTemplate().queryForObject(q, m, new UserRowMapper());
            if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)){
            	throw new UserBlockException("Your Account has been Blocked, Contact to Admin");
            }
            return u;
		} catch (EmptyResultDataAccessException e) {
			return null;

		}     
		
	}

	public List<User> getAllUser(String prop, Object propValue) {
          		return userDAO.findByProperty(prop, propValue);
	}

	public void changeLoginStatus(Integer userid, Integer loginStatus) {
             String q ="UPDATE  user SET loginStatus=:ls WHERE userid=:uid";
             Map m=new HashMap();
             m.put("ls", loginStatus);
             m.put("uid", userid);
             getNamedParameterJdbcTemplate().update(q, m);
	}

	public boolean isUserAvailable(String loginName) {
		String q= "SELECT count(loginName) FROM user WHERE loginName=?";
		Integer count=getJdbcTemplate().queryForObject(q, new String[]{loginName},Integer.class );
		if(count==1){
			return true;
		}else{
			return false;
		}
	}

	public boolean isEmailAvailable(String email) {
		String q= "SELECT count(email) FROM user WHERE email=?";
		Integer count=getJdbcTemplate().queryForObject(q, new String[]{email},Integer.class );
		if(count==1){
			return true;
		}else{
			return false;
		}
		
	}

	public User getUser(Integer userId) {
		return userDAO.findById(userId);
	}

	public int updateUser(User u) {
		
               return userDAO.update(u);		
	}

	public void deleteUser(Integer userId) {
          userDAO.deleteById(userId);		
	}

	public boolean resetPass(String email, String password) {
	try {
		String q="UPDATE user SET password=:pw WHERE email=:em";
		Map m=new HashMap();
		m.put("pw", password);
		m.put("em", email);
		getNamedParameterJdbcTemplate().update(q, m);
        return true;		
	}catch(Exception e) {
		e.printStackTrace();
		return false;
	}
		
	}

	



	
}
