package com.saksoft.test.databse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@Column(name = "First_Name")
	private String firtsName;
	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "Email")
	private String emailId;
	@Column(name = "Age")
	private int age;

	public PersonEntity() {

	}

	public PersonEntity(String firtsName, String lastName, String emailId, int age) {
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirtsName() {
		return firtsName;
	}

	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firtsName=" + firtsName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", age=" + age + "]";
	}

}
