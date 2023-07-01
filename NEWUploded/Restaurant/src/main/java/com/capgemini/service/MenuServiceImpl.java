package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Menu;
import com.capgemini.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuRepository MenuRepo;
	
	@Override
	public Menu addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return MenuRepo.save(menu);
	}

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return MenuRepo.findAll();
	}

	@Override
	public Menu deleteByid() {
		// TODO Auto-generated method stub
//		return MenuRepo.deleteById(null);
		return null;
	}

}
