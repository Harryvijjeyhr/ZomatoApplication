package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.IdNotFoundException;
import com.capgemini.exception.NoRecordsFound;
import com.capgemini.model.Menu;
import com.capgemini.model.Restaurant;
import com.capgemini.repository.RestaurantRepository;
import com.google.common.base.Optional;
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository RestRepo;

	@Override
	public Restaurant addRestaurant(Restaurant Restaurant) {
		// TODO Auto-generated method stub
		return RestRepo.save(Restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res, String restaurantId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(RestRepo.existsById(restaurantId)) {
			
			Restaurant restaurant = RestRepo.findById(restaurantId).get();
			restaurant.setRestaurantName(res.getRestaurantName());
			
			RestRepo.save(restaurant);
			return restaurant;
		}
		else {
			throw new IdNotFoundException();
		}
	}

	@Override
	public List<Restaurant> getAllRestaurant() throws NoRecordsFound {
		// TODO Auto-generated method stub
		List<Restaurant> rest =RestRepo.findAll();
		if(rest.isEmpty() == true) {
			throw new NoRecordsFound();
		}
		List<Restaurant> restaurant = RestRepo.findAll();
		return restaurant;
	}

	@Override
	public void deleteRestaurant(String restaurantId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		if(RestRepo.existsById(restaurantId)) {
			RestRepo.deleteById(restaurantId);
		}else {
			throw new IdNotFoundException();
		}
	}

}	







	
	
