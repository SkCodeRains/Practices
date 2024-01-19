package com.coderains.rainsbank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coderains.rainsbank.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {

}
