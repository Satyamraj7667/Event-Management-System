package com.eventmanagement.Model;

public class JwtResponse {
	
	private String jwtToken;
	private String username;
	private String firstname;
	private Long userid;
	private String role;
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public JwtResponse(String jwtToken, String username, String firstname, Long userid, String role) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.firstname = firstname;
		this.userid = userid;
		this.role = role;
	}
	public JwtResponse() {
		
	}
	

}
