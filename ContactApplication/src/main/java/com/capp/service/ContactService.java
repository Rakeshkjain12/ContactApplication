package com.capp.service;

import java.util.List;

import com.capp.domain.Contact;

public interface ContactService {
     public void save(Contact c);
     public void update(Contact c);
     public void delete(Integer contactId);
     public void delete(Integer[] contactIds);
     /* 
      * This method return all User Contact (User who in logged in)
      * 
      * 
      * */
     public Contact findContactById(Integer contactId);

     
     public List<Contact> findUserContact(Integer userId);
     /*
      * This method search contact for user(user id) based on given-txt-criteria(txt)
      * */
     public List<Contact> findUserContact(Integer userId, String txt);
}
