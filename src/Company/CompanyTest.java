package Company;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import Company.Employee.OCCUPATION;
import junit.framework.Assert;
import Company.Employee.LOCATION;

public class CompanyTest {
	private static Company company;

	@BeforeClass
	public static void setup() {
		company = new Company();
		company.addEmployee(new Employee("James", 16, OCCUPATION.SOFTWARE_ENGINEER, LOCATION.SAN_DIEGO));
		company.addEmployee(new Employee("Severa", 16, OCCUPATION.SOFTWARE_ENGINEER, LOCATION.SAN_DIEGO));
		company.addEmployee(new Employee("Logan", 16, OCCUPATION.SOFTWARE_ENGINEER, LOCATION.SAN_DIEGO));
		company.addEmployee(new Employee("Mark", 30, OCCUPATION.HR_EMPLOYEE, LOCATION.CHICAGO));
		company.addEmployee(new Employee("James", 40, OCCUPATION.HR_EMPLOYEE, LOCATION.LA));
	}

	@Test
	public void testCountSoftwareEngineers() {
		assertEquals(3, company.countSoftwareEngineers());
	}

	@Test
	public void testCount() {
		assertEquals(3, company.count(e -> e.isSoftwareEngineer()));
		assertEquals(2, company.count(e -> e.getAge() > 18));
	}

	@Test
	public void testAny() {
		assertTrue(company.any(e -> e.isSoftwareEngineer()));
		assertFalse(company.any(e -> e.getOccupation() == OCCUPATION.SALES_EMPLOYEE));
	}

	@Test
	public void testAll() {
		assertFalse(company.all(e -> e.isSoftwareEngineer()));
		assertTrue(company.all(e -> e.getAge() > 12));
	}

	@Test
	public void testMigrate() {
		assertTrue(company.getLoation("Mark") == "CHICAGO");
		company.applyToEmployess(e -> e.getLocation() == LOCATION.CHICAGO, e -> e.setLocation(LOCATION.SAN_DIEGO));
		assertTrue(company.getLoation("Mark") == "SAN_DIEGO");
	}
	
	@Test
	public void testNameChange(){
		Employee James = company.getEmployeeByName("James");
		company.applyToEmployess(e -> e.getName() == "James", e -> e.changeName("Jim"));
		assertTrue(James.getName().equals("Jim"));
	}
	
	public void testanyOf(){
		assertTrue(company.anyOf(e -> e.getAge() > 49, e -> e.getLocation() == LOCATION.LA));
		assertTrue(company.anyOf(e -> e.getName().equals("Jim"), e -> e.getName().equals("Alex")));
			
	}

}
