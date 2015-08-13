package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
public class Users {

    @Id
    @GeneratedValue
    private Long id;
   
    private String username;

    private String password;

    private boolean enabled;
    

    public static Users createUser(String username, String email, String password) {
        Users user = new Users();

        user.username = username;
        user.password = password;
      

        return user;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "username:"+this.username+" pass:"+this.password;
	}

	

	
	
    
    
}