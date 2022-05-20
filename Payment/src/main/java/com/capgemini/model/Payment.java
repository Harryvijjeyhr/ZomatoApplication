package com.capgemini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Document
public class Payment {

	@Id
    private String id;
	
	private long timestamp;
    private int amount;
    private String orderId;
    private CreditCardInfo creditCardInfo;
    
    @JsonIgnore
    public CreditCardInfo getCreditCardInfo() {
        return creditCardInfo;
    }

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(String id, long timestamp, int amount, String orderId, CreditCardInfo creditCardInfo) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.amount = amount;
		this.orderId = orderId;
		this.creditCardInfo = creditCardInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", timestamp=" + timestamp + ", amount=" + amount + ", orderId=" + orderId + "]";
	}

	
}
