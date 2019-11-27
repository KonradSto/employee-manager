package com.konradsto.employeedirectory.dao;

import com.konradsto.employeedirectory.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
