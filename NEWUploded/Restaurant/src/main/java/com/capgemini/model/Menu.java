package com.capgemini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="menu")
public class Menu {

	@Id
	private String menuId;
	private String restaurantName;
	private String restaurantId;
	private String menuName;
	private String price;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(String menuId, String restaurantName, String restaurantId, String menuName, String price) {
		super();
		this.menuId = menuId;
		this.restaurantName = restaurantName;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantName=" + restaurantName + ", restaurantId=" + restaurantId
				+ ", menuName=" + menuName + ", price=" + price + "]";
	}
	
	
}
