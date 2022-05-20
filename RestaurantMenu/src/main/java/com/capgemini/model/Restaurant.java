package com.capgemini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class Restaurant {

	//Attributes
	 	@Id
	    private String id;
	    private String name;

	    //defaultConstructor
		public Restaurant() {
			super();
			// TODO Auto-generated constructor stub
		}
		//paramaterised constructor
		public Restaurant(String id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		//getter and setter
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		//toString
		@Override
		public String toString() {
			return "Restaurant [id=" + id + ", name=" + name + "]";
		}
	    
	    
}
