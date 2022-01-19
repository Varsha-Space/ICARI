package com.wlg.icari.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Participant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@Size(min = 10, max = 10, message = "Must be a 10-digit number")
	private String phone;
	@NotBlank
	private String university;
	@NotBlank
	private String college;
	@NotBlank
	private String department;
	private String type;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}
	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}
	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Participant(int id, @NotBlank String name, @Email @NotBlank String email,
			@NotBlank @Size(min = 10, max = 10) String phone, @NotBlank String university, @NotBlank String college,
			String department, String type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.university = university;
		this.college = college;
		this.department = department;
		this.type = type;
	}
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", university="
				+ university + ", college=" + college + ", department=" + department + ", type=" + type + "]";
	}
	
}
