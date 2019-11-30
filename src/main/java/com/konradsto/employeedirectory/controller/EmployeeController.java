package com.konradsto.employeedirectory.controller;

import java.util.List;

import com.konradsto.employeedirectory.model.Employee;
import com.konradsto.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeService.findAllByLastNameOrderAsc());
        return "employees/employees-list";
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

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("employeeName") String theName, Model theModel) {
        List<Employee> theEmployees = employeeService.searchBy(theName);
        theModel.addAttribute("employees", theEmployees);
        return "/employees/employees-list";
    }
}
