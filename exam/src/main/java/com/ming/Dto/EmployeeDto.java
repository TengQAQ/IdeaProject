package com.ming.Dto;

public class EmployeeDto extends PageDto{
	private String username;
	private String phone;
	private Integer status;
	private String startTime;
	private String endTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "EmployeeDto{" +
				"username='" + username + '\'' +
				", phone='" + phone + '\'' +
				", status=" + status +
				", startTime='" + startTime + '\'' +
				", endTime='" + endTime + '\'' +
				'}';
	}
}
