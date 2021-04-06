package dataprovider;
public class Employee {
	private int id;
	private String name;
	private String deptName;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String deptName) {
		super();
		this.id = id;
		this.name = name;
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptName=" + deptName + "]";
	}
	
}