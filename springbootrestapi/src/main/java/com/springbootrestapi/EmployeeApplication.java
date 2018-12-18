package com.springbootrestapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.springbootrestapi.dao.ContactRepository;
import com.springbootrestapi.model.Contact;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df=new SimpleDateFormat("dd/mm/yyyyy");
		contactRepository.save(new Contact("firstName", "lastName", "email", df.parse("12/01/1998"), 101101, "photo.png"));
		
	}

}