package sampletesting;

//public class Employee implements Comparable<Employee>{
	
public class Employee {
	
	private String name;
	private int salary;
	
	
	public Employee(String name, int number) {
		super();
		this.name = name;
		this.salary = number;
	}
	
	public Employee() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int number) {
		this.salary = number;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + salary + "]";
	}

//	@Override
//	public int compareTo(Employee o) {
//		// TODO Auto-generated method stub
//		if(this.getSalary() > o.getSalary()) {
//			return 1;
//		}else {
//			return -1;
//		}
//		//return 0;
//	}
	
	

}
