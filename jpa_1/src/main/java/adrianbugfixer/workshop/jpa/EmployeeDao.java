package adrianbugfixer.workshop.jpa;

import java.util.List;

public interface EmployeeDao {
	public Employee getEmployee(int eid);
	public void updateEmployee(Employee employee);
	public void addEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public List<Employee> getAllEmployees();
}
