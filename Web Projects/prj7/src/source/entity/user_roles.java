package source.entity;

public class user_roles {
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String role;
	
	public user_roles(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}
	

	public user_roles() {
		// TODO Auto-generated constructor stub
	}
}
