package com.capgemini.model;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class Order {

	//Attributes
	@Id
    private String id;
    private String restaurantId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ItemQuantity> items;
    private int totalPrice;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String restaurantId, int totalPrice) {
		super();
		this.id = id;
		this.restaurantId = restaurantId;
		this.items = items;
		this.totalPrice = totalPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public List<ItemQuantity> getItems() {
		return items;
	}
	public void setItems(List<ItemQuantity> items) {
		this.items = items;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", restaurantId=" + restaurantId + ", items=" + items + ", totalPrice=" + totalPrice
				+ "]";
	}
  
 
    //paramaterised constructor

	
}
