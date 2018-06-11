package morganstanley;

public class CloneExample {

	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Urmi");
		try{
			Employee cloned = (Employee)e.clone();
			System.out.println(cloned.getName());
			System.out.println(cloned.getDesignation());
		}catch(CloneNotSupportedException c){
			c.printStackTrace();
		}

	}

}

class Employee implements Cloneable {
	private String name;
	private String designation;

	public Employee() {
		this.setDesignation("Programmer");
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
