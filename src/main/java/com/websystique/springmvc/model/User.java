package com.websystique.springmvc.model;

public class User {

	private long id;
	
	private String username;
	
	private String address;
	
	private String email;

	private String country; 

	private String group;

	
	public User(){
		id=0;
	}
	
	public User(long id, String username, String address, String email, String country){
		this.id = id;
		this.username = username;
		this.address = address;
		this.email = email;
		this.country = country;
		this.group = group;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGroup() { return group; }

	public void setGroup(String group) { this.group = group; }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", address=" + address
				+ ", email=" + email + "]";
	}
	

	
}
