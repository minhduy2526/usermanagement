package com.duytm.usermanagement.services.User;

import com.duytm.usermanagement.entities.User;
import com.duytm.usermanagement.repositories.User.MyUserRepository;
import com.duytm.usermanagement.repositories.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        try {
            if (user.getName() == null && user.getName().length() == 0) {
                return null;
            }
            if (user.getEmail() == null && user.getEmail().length() == 0) {
                return null;
            }
            if (user.getPhoneNumber() == null && user.getPhoneNumber().length() == 0) {
                return null;
            }
            return userRepository.save(user);

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<User> searchByLikeName(String name) {
        try {
            return userRepository.searchByLikeName(name);
        } catch (Exception ex) {
          return null;
        }
    }

    @Override
    public boolean updateUser(Long id, User user) {
        try {
            return userRepository.updateUser(id, user);
        } catch (Exception ex){
            return  false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            return userRepository.deleteUser(id);
        } catch (Exception ex) {
            return  false;
        }
    }

}
