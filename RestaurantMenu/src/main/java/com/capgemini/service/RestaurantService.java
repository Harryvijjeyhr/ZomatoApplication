package com.capgemini.service;
//importing required class
import java.util.List;

import com.capgemini.model.Restaurant;

public interface RestaurantService {

	//create a restaurant operation
	 Restaurant createRestaurant(Restaurant restaurant);
	 //get restaurant operation
	 Restaurant getRestaurantByName(String name);
	 //listing operation
	 public List<Restaurant> getAllRestaurant();
	 
	 //delete a restaurant by id operation
	 public void deleteRestaurantById(String id);
}
