package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.contactmodel;

@Repository
public interface contactrepository extends CrudRepository<contactmodel, Long>{


}
