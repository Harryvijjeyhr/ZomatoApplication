package com.capgemini.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Menu;
import com.capgemini.model.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {	
	
	List<Restaurant> findByRestaurantId(Menu menu);
	List<Restaurant> findByRestaurantName(String restaurantName);
}
