package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.IdNotFoundException;
import com.capgemini.exception.NoRecordsFound;
import com.capgemini.model.Restaurant;

public interface RestaurantService {

	Restaurant addRestaurant(Restaurant Restaurant);
	
	Restaurant updateRestaurant(Restaurant res, String restaurantId) throws IdNotFoundException;

	List<Restaurant> getAllRestaurant() throws NoRecordsFound;
	
	public void deleteRestaurant(String  restaurantId) throws IdNotFoundException;

	

	
	
	

	
	
	
}
