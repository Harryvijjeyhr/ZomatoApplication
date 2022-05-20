package com.capgemini.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.capgemini.model.MenuItem;

public interface MenuItemService {

	//listing operation
	List<MenuItem> findAllByRestaurantId(String restaurantId);
	//creating menu operation
    MenuItem createMenuItem(MenuItem menuItem);
    
    //uploading menuitem operation
    void uploadMenuItems(List<MenuItem> menuItems);
}
