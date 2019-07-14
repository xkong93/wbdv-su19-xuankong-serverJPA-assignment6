package com.example.wbdvsu19xuankongmyappassignment6.services;

import com.example.wbdvsu19xuankongmyappassignment6.models.User;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-07-14.
 */
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> createUser(User newUser) {
    userRepository.save(newUser);
    return findAllUsers();
  }

  public List<User> findAllUsers() {
    List<User> lists = (List<User>) userRepository.findAll();
    return lists;
  }


  public User findUserById(Long cid) {
    User user = userRepository.findById(cid).get();
    return user;
  }

  public User updateUser(Long cid, User newUser) {
    User user = userRepository.findById(cid).get();
    if (user != null) {
      user.setFirstName(newUser.getFirstName());
      user.setLastName(newUser.getLastName());
      user.setPassword(newUser.getPassword());
      user.setUsername(newUser.getUsername());
      return user;
    }
    return null;
  }

  public void deleteUser(Long cid) {
    userRepository.deleteById(cid);

  }
}
