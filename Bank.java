package org.nik.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bank {

	private String bname;
	private String loc;
	@Id
	private String ifsc;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Bank [bname=" + bname + ", loc=" + loc + ", ifsc=" + ifsc + ", account=" + account + "]";
	}
	
	
}
