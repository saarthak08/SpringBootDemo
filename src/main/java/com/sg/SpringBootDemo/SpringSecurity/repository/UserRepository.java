package com.sg.SpringBootDemo.SpringSecurity.repository;

import com.sg.SpringBootDemo.SpringSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findByEmail(String email);
}
