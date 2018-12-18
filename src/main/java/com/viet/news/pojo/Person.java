package com.viet.news.pojo;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
 
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String address;
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
	
}
