package com.konradsto.employeedirectory.controller;

import com.konradsto.employeedirectory.model.Employee;
import com.konradsto.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeService.findAll());
        return "employees/employees-list";
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
    return employeeService.getEmployee(id);
    }

    @PostMapping("/save")
    public String addEmployee (@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
    }
}
