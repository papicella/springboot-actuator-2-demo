package com.example.actuator2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping ("/")
    public String fetchEmps (Model model)
    {
        List<Employee> emps = employeeRepository.findAll();

        model.addAttribute("employees", emps);

        return "employees";
    }
}
