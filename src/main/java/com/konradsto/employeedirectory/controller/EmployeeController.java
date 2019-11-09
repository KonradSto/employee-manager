package com.konradsto.employeedirectory.controller;

import com.konradsto.employeedirectory.model.Employee;
import com.konradsto.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView("employee_dir");
        model.addObject(employeeService.findAll());
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView getEmployeeById(@PathVariable int id){
        ModelAndView model = new ModelAndView("employeePage");
        model.addObject(employeeService.getEmployee(id));
        return model;
    }

    @PostMapping("/{id}")
    public Employee addEmployee (@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@RequestParam int id){
        employeeService.deleteById(id);
    }
}
