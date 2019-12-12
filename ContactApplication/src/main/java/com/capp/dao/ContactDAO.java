package com.capp.dao;

import java.util.List;

import com.capp.domain.Contact;

public interface ContactDAO {
	   public void save(Contact c);
	   public void update(Contact c);
	   public void delete(Contact c);
	   public void deleteById(Integer contactId);
	   public Contact findById(Integer contactId);
	   public List<Contact> findAll();
	   public List<Contact> findByProperty(String prop,Object propValue);
}
