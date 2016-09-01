package Company;

import Company.Employee.LOCATION;

public class Employee {
	
	public static enum OCCUPATION {SOFTWARE_ENGINEER, HR_EMPLOYEE, SALES_EMPLOYEE};
	public static enum LOCATION {SAN_DIEGO, LA, NY, CHICAGO};
	private String name;
	private int age;
	private OCCUPATION occupation;
	private LOCATION location;
	private int bonus;
	
	public Employee(String name, int age, OCCUPATION occupation, LOCATION location) {
		this.name= name;
		this.age = age;
		this.occupation = occupation;
		this.location = location;
	}

	public boolean isSoftwareEngineer() {
		return occupation == OCCUPATION.SOFTWARE_ENGINEER;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public OCCUPATION getOccupation() {
		return occupation;
	}

	public LOCATION getLocation() {
		return location;
	}
	
	private void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public void changeName(String name) {
		this.name = name;
	}


	public void setLocation(LOCATION a) {
		location = a;
	}
	
	
}
