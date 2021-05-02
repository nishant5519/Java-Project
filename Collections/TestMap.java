package Collections;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<Animal, String> map = new HashMap<Animal, String>();
		Animal animal1 = new Animal();
		animal1.setId(1);
		animal1.setName("Sachin");
		animal1.setSalary(new BigDecimal(100000));
		animal1.setDateOfBirth(new Date(1987, 2, 1));

		map.put(animal1, "India");

		Animal animal2 = new Animal();
		animal2.setId(1);
		animal2.setName("Sachin");
		animal2.setSalary(new BigDecimal(100000));
		animal2.setDateOfBirth(new Date(1987, 2, 1));

		map.put(animal2, "Japan");

		System.out.println(map);

	}

}

class Animal {

	private long id;
	private String name;
	private Date dateOfBirth;
	private BigDecimal salary;

	// Getter and Setters
	// toString
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Animal employee = (Animal) o;
		if (id != employee.id)
			return false;
		if (name != null ? !name.equals(employee.name) : employee.name != null)
			return false;
		if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth)
				: employee.dateOfBirth != null)
			return false;
		return salary != null ? salary.equals(employee.salary)
				: employee.salary == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result
				+ (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
		result = 31 * result + (salary != null ? salary.hashCode() : 0);
		return result;
	}

}
