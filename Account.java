package org.nik.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	private String name;
	@Id
	private long accno;
	private String dob;
	private int pin;
	private double money;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public void deposit(double amount) {
		money=money+amount;
	}
	public void withdraw(double amount) {
		money=money-amount;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", accno=" + accno + ", dob=" + dob + ", pin=" + pin + ", money=" + money
				+ "]";
	}
	
}
