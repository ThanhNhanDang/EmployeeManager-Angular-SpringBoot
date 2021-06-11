package com.java.dto;

public class EmployeeDto {
	
	private Long  		id; 
	private String 		name;
	private String 		email;
	private String 		jobTitle;
	private String 		phone;
	private String 		imageUrl;
	private String 		employeeCode;

	public EmployeeDto() {}
	
	
	public Long getId() {
		return id;
	}
	
	public EmployeeDto( String name, String email, String jobTitle, String phone, String imageUrl,
			String employeeCode) {
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.employeeCode = employeeCode;
	}

	public EmployeeDto(Long id, String name, String email, String jobTitle, String phone, String imageUrl,
			String employeeCode) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.employeeCode = employeeCode;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
}
