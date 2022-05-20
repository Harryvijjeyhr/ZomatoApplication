package com.capgemini.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)

@Document
public class Order {

	//atrributes
	 	@Id
	    private String id;

	    private String restaurantId;
	    private List<ItemQuantity> items;
	    private int totalPrice;
	    private long orderTime;
	    private String specialNote;
	    private String paymentId;
	    private long deliveryTime;

	    private UserInfo userInfo;

	    public UserInfo getUserInfo() {
	        return userInfo;
	    }

	    //default constructor
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}

		//paramaterised constructor
		public Order(String id, String restaurantId, List<ItemQuantity> items, int totalPrice, long orderTime,
				String specialNote, String paymentId, long deliveryTime, UserInfo userInfo) {
			super();
			this.id = id;
			this.restaurantId = restaurantId;
			this.items = items;
			this.totalPrice = totalPrice;
			this.orderTime = orderTime;
			this.specialNote = specialNote;
			this.paymentId = paymentId;
			this.deliveryTime = deliveryTime;
			this.userInfo = userInfo;
		}

		//getter and setter
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

		public long getOrderTime() {
			return orderTime;
		}

		public void setOrderTime(long orderTime) {
			this.orderTime = orderTime;
		}

		public String getSpecialNote() {
			return specialNote;
		}

		public void setSpecialNote(String specialNote) {
			this.specialNote = specialNote;
		}

		public String getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(String paymentId) {
			this.paymentId = paymentId;
		}

		public long getDeliveryTime() {
			return deliveryTime;
		}

		public void setDeliveryTime(long deliveryTime) {
			this.deliveryTime = deliveryTime;
		}

		public void setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
		}

		//toString 
		@Override
		public String toString() {
			return "Order [id=" + id + ", restaurantId=" + restaurantId + ", totalPrice=" + totalPrice + ", orderTime="
					+ orderTime + ", specialNote=" + specialNote + ", paymentId=" + paymentId + ", deliveryTime="
					+ deliveryTime + ", userInfo=" + userInfo + "]";
		}
	    
	    
}
