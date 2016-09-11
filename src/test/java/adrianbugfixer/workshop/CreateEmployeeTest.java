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

public class CreateEmployeeTest {

	Connection connection;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
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
	public void testIfConnectionNotNull(){
		assertNotNull(connection);
	}
	
	
}
