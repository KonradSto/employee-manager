package com.konradsto.employeedirectory.service;

import java.util.List;
import java.util.Optional;

import com.konradsto.employeedirectory.dao.EmployeeRepository;
import com.konradsto.employeedirectory.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(int id){
        Optional<Employee> employee = employeeRepository.findById(id);

        Employee theEmployee = null;

        if (employee.isPresent()){
            theEmployee = employee.get();
        }
        return theEmployee;
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public List<Employee> findAllByLastNameOrderAsc(){
        return employeeRepository.findAllByOrderByLastNameAsc();
    }
}
