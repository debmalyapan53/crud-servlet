
public class Employee {
	private int id;
	private String name;
	private String pwd;
	private String email;
	private String country;
	Employee(int id,String name,String pwd,String email,String country){
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.country = country;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
