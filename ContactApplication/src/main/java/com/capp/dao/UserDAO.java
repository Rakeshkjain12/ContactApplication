package com.capp.dao;

import java.util.List;

import com.capp.domain.User;

public interface UserDAO {
   public void save(User u);
   public int update(User u);
   public void delete(User u);
   public void deleteById(Integer userId);
   public User findById(Integer userId);
   public List<User> findAll();
   public List<User> findByProperty(String prop,Object propValue);
  
}
