package adrianbugfixer.workshop;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import adrianbugfixer.workshop.jpa.Employee;
import adrianbugfixer.workshop.jpa.EmployeeDao;
import adrianbugfixer.workshop.jpa.EmployeeDaoImpl;

public class CreateEmployeeTest {

	Connection connection;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA_Test");
	EntityManager entitymanager = emfactory.createEntityManager();

	@Before
	public void before() {
		entitymanager.getTransaction().begin();
		connection = entitymanager.unwrap(java.sql.Connection.class);
	}
	
	@After
	public void after() {
		entitymanager.getTransaction().commit();
	}
	
	@Test
	public void testIfConnectionNotNull() {
		assertNotNull(connection);
	}
	
	@Test
	public void testAddEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee employee = new Employee(1, "John", 2000.00, "Master" );
		employeeDao.addEmployee(employee);
		assertEquals(1, employeeDao.getAllEmployees().size(), 0);
		employee = employeeDao.getEmployee(1);
		assertEquals("John", employee.getEname());
		assertEquals(2000.0, employee.getSalary(), 0);
		assertEquals("Master", employee.getDeg());
	}
}
