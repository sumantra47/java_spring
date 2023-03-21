package sampletesting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sortbyemployeesalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e1 = new Employee("Ravi", 300);
		Employee e2 = new Employee("Sarita", 1300);
		Employee e3 = new Employee("Rahul", 340);
		Employee e4 = new Employee("Kusum", 11300);
		Employee e5 = new Employee("Anand", 10);
		
		
		List<Employee> empl = new ArrayList<Employee>();
		empl.add(e1);
		empl.add(e2);
		empl.add(e3);
		empl.add(e4);
		empl.add(e5);
		Comparator<Employee> comp = new Comparator<Employee>() {
			// for implementing your own sort logic
			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				
				if(o1.getName().compareTo(o2.getName())>0) {
					return 1;
				}else {
					return -1;
				}
				
			}
		};
		Collections.sort(empl,comp.reversed());
		empl.forEach(emp -> System.out.println(emp));
		
		

	}

}
