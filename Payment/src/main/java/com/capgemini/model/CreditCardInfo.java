package com.capgemini.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreditCardInfo {

	private String firstName;
    private String lastName;
    private int expiredMonth;
    private int expiredYear;
    private int securityCode;
	public CreditCardInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditCardInfo(String firstName, String lastName, int expiredMonth, int expiredYear, int securityCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.expiredMonth = expiredMonth;
		this.expiredYear = expiredYear;
		this.securityCode = securityCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getExpiredMonth() {
		return expiredMonth;
	}
	public void setExpiredMonth(int expiredMonth) {
		this.expiredMonth = expiredMonth;
	}
	public int getExpiredYear() {
		return expiredYear;
	}
	public void setExpiredYear(int expiredYear) {
		this.expiredYear = expiredYear;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	@Override
	public String toString() {
		return "CreditCardInfo [firstName=" + firstName + ", lastName=" + lastName + ", expiredMonth=" + expiredMonth
				+ ", expiredYear=" + expiredYear + ", securityCode=" + securityCode + "]";
	}
    
    
}
