package com.capgemini.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Document
public class ItemQuantity {

	 	private String name;
	    private int price;
	    private int quantity;
		public ItemQuantity() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ItemQuantity(String name, int price, int quantity) {
			super();
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		@Override
		public String toString() {
			return "ItemQuantity [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
		}
	    
	    
}
