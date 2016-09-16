package domain.model;

public class Role {

	private Integer roleId;
	
	private String name;

	public Role(Integer roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(final Object o){
		if (this == o) {
			return true;
		} else if (o instanceof Role && ((Role)o).getRoleId() == this.getRoleId()) {
			return true;
		}
		return false;
	}
	
}
