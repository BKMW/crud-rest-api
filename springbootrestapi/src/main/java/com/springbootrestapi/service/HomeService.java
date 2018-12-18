package com.springbootrestapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootrestapi.model.Employee;

@Service
public class HomeService {
	
	public List<Employee> data = new ArrayList<Employee>(
			Arrays.asList(
			new Employee((long) 1,"test1","test","test"),
			new Employee((long) 2,"test2","test","test"),
			new Employee((long) 3,"test3","test","test"))
			);
	public List<Employee> findAll() {
		return data;
		
	}
	public Employee findOne(Long id ) {
		for(Employee emp:data) {
			if(emp.getId()==id)return emp;
		}
		return null;
		
	}
	
	public boolean save(Employee employee) {
		return data.add(employee);
	}
	public boolean delete(Long id) {
		for(Employee emp:data) {
			if(emp.getId()==id)
			  return data.remove(emp);
		}
		return false;
		 
	}
	public boolean edit(Employee employee) {
		for(Employee emp:data) {
			if(emp.getId()==employee.getId()) {
			   data.remove(emp);
			return data.add(employee);
			}
		}
		return false;
		 
	}
	

}
