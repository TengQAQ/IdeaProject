package com.hxzy.Dto;

public class UserLoginDto {
	private String username;
	private String password;
	private String loginIp;

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

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Override
	public String toString() {
		return "UserLoginDto{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", loginIp='" + loginIp + '\'' +
				'}';
	}
}
