package Company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Company {
	private List<Employee> employees = new ArrayList<Employee>();

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public String getLoation(String employeName) {
		AtomicReference<String> ret = new AtomicReference<String>("Error: Person Not Found");
		employees.forEach(i -> {
			if (i.getName().equals(employeName)) {
				ret.set(i.getLocation().toString());
			}
		});
		return ret.get();
	}
	public Employee getEmployeeByName(String employeName) {
		AtomicReference<Employee> ret = new AtomicReference<Employee>(null);
		employees.forEach(i -> {
			if (i.getName().equals(employeName)) {
				ret.set(i);
			}
		});
		return ret.get();
	}
	

	public int countSoftwareEngineers() {
		AtomicInteger a = new AtomicInteger(0);
		employees.forEach(i -> {
			if (i.isSoftwareEngineer()) {
				a.set(a.get() + 1);
			}
		});
		return a.get();
	}

	public int count(Predicate<Employee> p) {
		AtomicInteger a = new AtomicInteger(0);
		employees.forEach(i -> {
			if (p.test(i)) {
				a.set(a.get() + 1);
			}
		});
		return a.get();
	}

	public boolean any(Predicate<Employee> p) {
		AtomicBoolean anyAreTure = new AtomicBoolean(false);
		employees.forEach(i -> {
			if (p.test(i)) {
				anyAreTure.set(true);
			}
		});
		return anyAreTure.get();
	}

	public boolean all(Predicate<Employee> p) {
		AtomicBoolean allAreTrue = new AtomicBoolean(true);
		employees.forEach(i -> {
			if (!p.test(i)) {
				allAreTrue.set(false);
			}
		});
		return allAreTrue.get();
	}

	public void applyToEmployess(Predicate<Employee> argument, Consumer<Employee> opration) {
		AtomicReference<String> ret = new AtomicReference<String>("Error: Person Not Found");
		employees.forEach(i -> {
			if (argument.test(i)) {
				opration.accept(i);
			}
		});

	}

	public boolean anyOf(Predicate<Employee> p, Predicate<Employee> p1) {
		AtomicBoolean anyAreTure = new AtomicBoolean(false);
		employees.forEach(i -> {
			if (p.or(p1).test(i)) {
				anyAreTure.set(true);
			}
		});
		return anyAreTure.get();
	}
	

}
