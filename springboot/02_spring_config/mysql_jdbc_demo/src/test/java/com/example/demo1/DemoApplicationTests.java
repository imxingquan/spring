package com.example.demo1;

import com.example.demo1.jpa.Employee;
import com.example.demo1.jpa.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DemoApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;


	@Test
	public void contextLoads() {
		assertEquals("a","a");
	}

	@Test
	public void testEmployeeRepository(){
		Employee employee = new Employee("xing", "泉", "中年大叔");
		employeeRepository.save(employee);
		employeeRepository.flush();
		Employee employee2 = employeeRepository.findByFirstName("xing");
		assertEquals(employee2.getFirstName(),"xing");
	}

}
