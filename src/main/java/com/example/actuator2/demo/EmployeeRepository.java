package com.example.actuator2.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource (collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
