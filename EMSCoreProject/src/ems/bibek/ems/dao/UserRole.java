package ems.bibek.ems.dao;

public enum UserRole {
	
	User("user"), ADMIN("admin");
	
	String role;
	
	UserRole(String role){
		this.role=role;
	}

	public String getRole() {
		return role;
	}
	
	
		
}
