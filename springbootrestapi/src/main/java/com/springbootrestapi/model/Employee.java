package com.springbootrestapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Employees")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)	
private Long Id;
	
@NotBlank
private String name;
@NotBlank
private String designation;

@NotBlank
private String expertise;

@Temporal(TemporalType.TIMESTAMP)
@LastModifiedDate
private Date createdAt;
 public Employee() {
	// TODO Auto-generated constructor stub
}
public Employee(Long Id, String name, String designation, String expertise) {
	this.Id=Id;
	this.name = name;
	this.designation = designation;
	this.expertise = expertise;
}

public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getExpertise() {
	return expertise;
}
public void setExpertise(String expertise) {
	this.expertise = expertise;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
}