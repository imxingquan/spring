package com.example.demo1.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Employee findByFirstName(String firstName);


}
