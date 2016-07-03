package model;

public class User {

	private Integer userId;
	
	private String name;
	
	private String lastName;
	
	private Integer age;

	public User(Integer userId, String name, String lastName, Integer age) {
		super();
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
