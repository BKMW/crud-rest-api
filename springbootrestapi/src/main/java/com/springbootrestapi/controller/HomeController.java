package com.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.model.Employee;
import com.springbootrestapi.service.HomeService;


@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	
	@RequestMapping("")
	public String Index(){
		return " Hello, welcome to spring boot !";
	}
	@RequestMapping("/{name}/{name1}")
	public String IndexWithPrams(@PathVariable String name,@PathVariable String name1){
		return String.format(" Hello %s, welcome  %s to spring boot !", name,name1);
	}
	@RequestMapping("/employees")
	public List<Employee> GetEmployees(){
		
		return homeService.findAll();
	}
	@RequestMapping("/employees/{id}")
	public Employee GetEmployees(@PathVariable Long id){
		
		return homeService.findOne(id);
	}
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee){
		
		 if(homeService.save(employee))
		    return employee;
		 
		 return null;
	}
	@DeleteMapping("/employees/{id}") 
	public void delete(@PathVariable Long id){
		 homeService.delete(id);
	}
	@PutMapping("/employees")
	public Employee edit(@RequestBody Employee employee){
		
		 if(homeService.edit(employee))
		    return employee;
		 
		 return null;
	}
}
