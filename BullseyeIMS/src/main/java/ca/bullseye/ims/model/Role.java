package ca.bullseye.ims.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
    private Set<Employee> employees;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
