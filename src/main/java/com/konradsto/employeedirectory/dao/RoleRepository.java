package com.konradsto.employeedirectory.dao;

import com.konradsto.employeedirectory.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
