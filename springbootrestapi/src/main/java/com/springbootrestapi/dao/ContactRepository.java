package com.springbootrestapi.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootrestapi.model.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	@Query("select c from Contact c where c.firstName like :x")
	public Page<Contact> search(@Param("x")String ws, Pageable pageable);

}
 