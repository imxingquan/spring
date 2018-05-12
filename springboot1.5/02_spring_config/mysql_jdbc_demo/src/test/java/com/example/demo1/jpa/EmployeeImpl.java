package com.example.demo1.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeImpl")
public class EmployeeImpl implements EmployeeService {


    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeImpl(EmployeeRepository empRep) {
        this.employeeRepository = empRep;

    }

    @Transactional
    public void addEmployee(String empName) {
       employeeRepository.save(new Employee("xing","kkkk","teee ddd"));
    }
}
