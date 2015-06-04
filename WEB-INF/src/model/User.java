package model;

import java.nio.channels.SeekableByteChannel;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;


public class User {

	private int id;
	private String login;
	private String password;
	private Role role;

	public User() {

	}
	
	public User(String sessionAttribute) {
		String temp[] = sessionAttribute.split(",");
		
		id = Integer.parseInt(temp[0].split("=")[1]);
		login = temp[1].split("=")[1];
		password = temp[2].split("=")[1];
		role = new Role(temp[3].split("=")[1]);
	}

	@Override
	public String toString() {
		return "id=" + id + ", login=" + login + ", password=" + password
				+ ", role=" + role;
	}

	public void reset(){
		id = 0;
		login = null;
		password = null;
		role = null;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

}
