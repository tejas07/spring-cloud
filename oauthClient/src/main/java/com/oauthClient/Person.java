package com.oauthClient;

public class Person {
	private Integer age;
	private String name;
	private String phoneNumber;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "TestPojo [age=" + age + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
}
