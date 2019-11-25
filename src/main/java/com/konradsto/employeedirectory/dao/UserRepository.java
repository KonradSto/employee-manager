package com.konradsto.employeedirectory.dao;

import com.konradsto.employeedirectory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
