package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.MenuItem;
import com.capgemini.model.Restaurant;
import com.capgemini.service.MenuItemService;
import com.capgemini.service.RestaurantService;

@RestController
@RequestMapping("/api/r1")
public class RestaurantMenuController {

	RestaurantService restaurantService;
    MenuItemService menuItemService;

    @Autowired
    public RestaurantMenuController(RestaurantService restaurantService, MenuItemService menuItemService) {
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
    }

    
    //create a new restaurant -post method
    @RequestMapping(value = "/restaurant")
	 public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
	        return new ResponseEntity<>(restaurantService.createRestaurant(restaurant),HttpStatus.CREATED);
	    }
  
  //find a restaurant--using of get method
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public Restaurant findRestaurant(@RequestParam(value = "name") String name) {
        Restaurant savedRes= restaurantService.getRestaurantByName(name);
        
        return savedRes;
    }

  //list  a menuitme by  restaurant--using of get method
    @RequestMapping(value = "/restaurants/{restaurantId}/menuItems", method = RequestMethod.GET)
    public List<MenuItem> getMenuItems(@PathVariable String restaurantId) {
    	return  menuItemService.findAllByRestaurantId(restaurantId);
         
    }

    //create a menuitem--using of post method
    @RequestMapping(value = "/restaurant/{rid}/menuItems", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
       MenuItem menucon = menuItemService.createMenuItem(menuItem);
       return menucon;
    }

    
    @RequestMapping(value = "/restaurants/bulk/menuItems", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<MenuItem> menuItems) {
        this.menuItemService.uploadMenuItems(menuItems);
    }
    
    //delete  a restaurant
    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<Void> delteRestaurantById(String id) {
    	restaurantService.deleteRestaurantById(id);
    	return ResponseEntity.noContent().build();
    
    }
    @GetMapping("/test")
	public String test() {
		return "test";
	}
}




































//create a restaurant--using of post method
//@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
//@ResponseStatus(value = HttpStatus.CREATED)
//public Restaurant createRestaurant(Restaurant restaurant) {
//  Restaurant savedRest = restaurantService.createRestaurant(restaurant);
//  return savedRest;
//}
