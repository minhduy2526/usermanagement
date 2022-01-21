package com.duytm.usermanagement.repositories.User;

import com.duytm.usermanagement.entities.User;

import java.util.List;

public interface MyUserRepository {
    List<User> searchByLikeName(String name);
    boolean updateUser(Long id, User user);
    boolean deleteUser(Long id);
}
