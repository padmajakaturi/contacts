package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.contactmodel;
import com.example.demo.repository.contactrepository;

@Service
public class contactservice  {
	@Autowired
	private contactrepository repo;

	public List<contactmodel> getall() {
		return (List<contactmodel>) repo.findAll();
	}

	public void addContact(contactmodel u) {
		repo.save(u);
	}

	public contactmodel getById(long id) {
		return repo.findById(id).orElse(null);
	}

	public void deleteById(long id) {
		repo.deleteById(id);

	}

}
