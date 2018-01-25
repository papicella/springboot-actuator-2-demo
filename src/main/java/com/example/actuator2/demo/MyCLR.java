package com.example.actuator2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class MyCLR implements CommandLineRunner {


    private EmployeeRepository employeeRepository;

    @Autowired
    public MyCLR(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("pas", "lucia", "siena", "lucas")
                .forEach(name -> employeeRepository.save(new Employee(name)));

        employeeRepository.findAll().forEach(System.out::println);
    }
}
