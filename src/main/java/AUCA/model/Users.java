package AUCA.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "all_users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public String user_id;
	
	
	@Column(name = "user_email")
	public String user_email;
	
	@Column(name = "user_password")
	public String user_password;
	
	@Column(name = "user_role")
	public String user_role;

	public Users() {
		super();
	}

	public Users(String user_email) {
		super();
		this.user_email = user_email;
	}

	public Users(String user_email, String user_password, String user_role) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_role = user_role;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	

}
