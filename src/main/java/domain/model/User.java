package domain.model;

public class User {

	private Integer userId;
	
	private String name;
	
	private String lastName;
	
	private Integer age;
	
	private Role role;
	
	public User() {
		super();
	}

	public User(String name, String lastName, Integer age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public Integer getUserId() {
		return userId;
	}

	private void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	private void setAge(Integer age) {
		this.age = age;
	}
	
	public Role getRole() {
		return role;
	}

	private void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(final Object o){
		if (this == o) {
			return true;
		} else if (o instanceof User && ((User)o).getUserId() == this.getUserId()) {
			return true;
		}
		return false;
	}
	
}
