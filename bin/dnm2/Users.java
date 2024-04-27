package dnm2;


public class Users {
	
	private String Username;
	private String password;
	
	
	public Users(String username, String string) {
		super();
		this.Username = username;
		this.password = string;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
