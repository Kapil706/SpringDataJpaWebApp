package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Authors;

public interface AuthorRepository extends CrudRepository<Authors,Long>{

}
