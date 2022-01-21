package com.duytm.usermanagement.repositories.User;

import com.duytm.usermanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, MyUserRepository {
}
