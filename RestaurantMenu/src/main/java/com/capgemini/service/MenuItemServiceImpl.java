package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.MenuItem;
import com.capgemini.repository.MenuItemRepository;

//annotation
@Service
public class MenuItemServiceImpl implements MenuItemService {

	 private MenuItemRepository menuItemRepository;

	    @Autowired
	    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
	        this.menuItemRepository = menuItemRepository;
	    }

	    //list menu operation
	    @Override
	    public List<MenuItem> findAllByRestaurantId(String restaurantId) {
	        return menuItemRepository.findAllByRestaurantId(restaurantId);
	    }

	    //creating menu operation
	    @Override
	    public MenuItem createMenuItem(MenuItem menuItem) {
	        MenuItem menusave = menuItemRepository.save(menuItem);
	        return menusave;
	    }

	    //upload menuitem operation
	    @Override
	    public void uploadMenuItems(List<MenuItem> menuItems) {
	        menuItemRepository.saveAll(menuItems);
	    }
}
