package com.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.dao.ContactRepository;
import com.springbootrestapi.model.Contact;

@RestController
@RequestMapping("contacts")
public class ContactsController {
	@Autowired
	ContactRepository contactRepository;
	//findAll
	@GetMapping("search")
	public Page<Contact> search(@RequestParam(name="ws",defaultValue="") String ws,
			                    @RequestParam(name="page",defaultValue="0") int page,
			                    @RequestParam(name="size",defaultValue="5") int size) {
		return contactRepository.search("%"+ws+"%", new PageRequest(page, size));
	}
	//search
		@GetMapping("")
		public List<Contact> findAll() {
			return contactRepository.findAll();
		}
	//findOne
	@GetMapping("{id}")
	public Contact findOne(@PathVariable Long id) {
		return contactRepository.findOne(id);
	}
	//save
	@PostMapping("")
	public Contact save(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}

	//update
	@PutMapping("{id}")
	public Contact update(@PathVariable Long id,@RequestBody Contact contact) {
		contact.setId(id);
		return contactRepository.save(contact);
		
	}
	//update
		@PutMapping("")
		public Contact update(@RequestBody Contact contact) {
			return contactRepository.save(contact);
			
		}
	
	//delete
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		contactRepository.delete(id);
	}

}
