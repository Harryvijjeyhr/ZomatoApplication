package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jca.cci.core.CciTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.capgemini.exception.IdNotFoundException;
import com.capgemini.exception.NoRecordsFound;
import com.capgemini.model.Menu;
import com.capgemini.model.Restaurant;
import com.capgemini.service.MenuService;
import com.capgemini.service.RestaurantService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/r1")
public class RestaurantController {

	RestaurantService RestServ;
	MenuService MenuServ;
	
	
	@Autowired
	public RestaurantController(RestaurantService RestServ,MenuService MenuServ) {
		this.RestServ=RestServ;
		this.MenuServ=MenuServ;
	}
	
	
	@RequestMapping(value = "/restaurants")
	 public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant Restaurant) {
	        return new ResponseEntity<>(RestServ.addRestaurant(Restaurant),HttpStatus.CREATED);
	    }

	
	@RequestMapping(value="/allRestaurant")
	public List<Restaurant> getAllRestaurant() throws NoRecordsFound{
		return RestServ.getAllRestaurant();
	}
	
	//menuList
	@RequestMapping(value="/allMenu")
	public List<Menu> getAllMenu(){
		return MenuServ.getAllMenu();
	}
	
	//add menu
	@RequestMapping(value = "/menu")
	 public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
	        return new ResponseEntity<>(MenuServ.addMenu(menu),HttpStatus.CREATED);
	 }
	
	
	@RequestMapping(value="/deleteRestaurant/{restaurantId}")
	public ResponseEntity<Void> deleteRestaurant(@PathVariable String restaurantId) throws IdNotFoundException{
		RestServ.deleteRestaurant(restaurantId);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/updateRestaurant/{restaurantId}")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant res, @PathVariable String restaurantId) throws IdNotFoundException{
		return new ResponseEntity<Restaurant> (RestServ.updateRestaurant(res, restaurantId), HttpStatus.CREATED);
	}
}
