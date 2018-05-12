package com.example.demo1;

import com.example.demo1.jpa.Employee;
import com.example.demo1.jpa.EmployeeImpl;
import com.example.demo1.jpa.EmployeeRepository;
import com.example.demo1.jpa.EmployeeService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@WebAppConfiguration
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DemoApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeImpl;

	@Test
	public void contextLoads() {
		assertEquals("a","a");
	}

	@Test
	public void testEmployeeRepository(){
		Employee employee = new Employee("xing", "泉", "中年大叔");
		employeeRepository.save(employee);
		//employeeRepository.flush();
		//Employee employee2 = employeeRepository.findByFirstName("xing");
		//assertEquals(employee2.getFirstName(),"xing");
	}

	@Test
	public void testEmployeeImpTransactional(){
		employeeImpl.addEmployee("xing");
	}

}
