package com.duytm.usermanagement.repositories.User;

import com.duytm.usermanagement.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class MyUserRepositoryImpl implements MyUserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    @Override
    public List<User> searchByLikeName(String name) {
        try {
            String sql = "SELECT id, name, email, phone_number, is_existed " +
                    " FROM users " +
                    " WHERE name like ?";
            Query query = entityManager.createNativeQuery(sql, User.class);
            query.setParameter(1,"%" + name + "%");
            List<User> users = query.getResultList();

            if (users != null) {
                return users;
            } else  {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean updateUser(Long id, User user) {
        try {
                String sql = "UPDATE users " +
                        "SET name = ?, email = ?, phone_number = ?, is_existed = ? " +
                        "WHERE id = ?";
                Query query = entityManager.createNativeQuery(sql, User.class);
                query.setParameter(1, user.getName());
                query.setParameter(2, user.getEmail());
                query.setParameter(3, user.getPhoneNumber());
                query.setParameter(4, user.isExisted());
                query.setParameter(5, id);
                int check = query.executeUpdate();
                if (check > 0) {
                    return true;
                }
            return  false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteUser(Long id) {
        try {
            String sql = "UPDATE users " +
                    "SET is_existed = ? " +
                    "WHERE id = ?";
            Query query = entityManager.createNativeQuery(sql, User.class);
            query.setParameter(1, false);
            query.setParameter(2, id);
            int check = query.executeUpdate();
            if (check > 0) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return  false;
        }
    }


}
