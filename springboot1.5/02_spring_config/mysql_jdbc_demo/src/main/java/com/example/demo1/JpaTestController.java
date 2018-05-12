package com.example.demo1;

import com.example.demo1.jpa.Employee;
import com.example.demo1.jpa.EmployeeRepository;
import com.example.demo1.jpa.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jpa")
public class JpaTestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test(@PathVariable("field") String field,
                         Model model){
        Employee employee = new Employee("xing", "泉", "中年大叔");

        employeeRepository.save(employee);


        return "ok";

    }

    @RequestMapping(value="testservice",method=RequestMethod.GET)
    public void testService(){
        employeeService.addEmployee("hi");
    }
}
