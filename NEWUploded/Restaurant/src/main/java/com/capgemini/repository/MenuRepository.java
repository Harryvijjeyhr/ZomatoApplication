package com.capgemini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {

}
