package com.duytm.usermanagement.services.User;

import com.duytm.usermanagement.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> searchByLikeName(String name);
    boolean updateUser(Long id, User user);
    boolean deleteUser(Long id);
    List<User> getAllUsers();
}
