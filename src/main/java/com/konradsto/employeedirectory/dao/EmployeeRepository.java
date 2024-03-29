package com.konradsto.employeedirectory.dao;

import java.util.List;

import com.konradsto.employeedirectory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAsc();

    List<Employee> findByNameContainsOrLastNameContainsAllIgnoreCase(String theName, String theLastName);
}
