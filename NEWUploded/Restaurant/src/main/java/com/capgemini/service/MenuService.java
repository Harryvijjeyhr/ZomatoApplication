package com.capgemini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.model.Menu;

@Service
public interface MenuService {

	Menu addMenu(Menu menu);
	
	List<Menu> getAllMenu();
	
	Menu deleteByid();
}
