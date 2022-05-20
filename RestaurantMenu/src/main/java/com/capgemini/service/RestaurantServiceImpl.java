package com.capgemini.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Restaurant;
import com.capgemini.repository.RestuarantRepository;

//annotation
@Service
public class RestaurantServiceImpl implements RestaurantService {

	 private RestuarantRepository restaurantRepository;

	 
	    @Autowired
	    public RestaurantServiceImpl(RestuarantRepository restaurantRepository) {
	        this.restaurantRepository = restaurantRepository;
	    }
	    //create a restaurant operation
	    @Override
	    public Restaurant createRestaurant(Restaurant restaurant) {
	        Restaurant res =restaurantRepository.save(restaurant);
	        return res;
	    }

	    //get a restaurant by name operation
	    @Override
	    public Restaurant getRestaurantByName(String name) {
	        Restaurant restaurant = restaurantRepository.findFirstByName(name);
	        return restaurant;
	    }

	    //get a restaurant operation
		@Override
		public List<Restaurant> getAllRestaurant() {
			// TODO Auto-generated method stub
			return (List<Restaurant>)restaurantRepository.findAll();
		}

		//delete a restaurant by id operation
		@Override
		public  void deleteRestaurantById(String id) {
			restaurantRepository.deleteById(id);
			
		}
		
	
}
