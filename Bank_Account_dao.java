package org.nik.dao;

import java.util.List;

import javax.persistence.*;

import org.nik.dto.Account;
import org.nik.dto.Bank;

public class Bank_Account_dao {

	private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	private EntityManager entityManager=entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void saveBank(Bank bank) {
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
	}
	
	public void saveAccount(Account account) {
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
	}
	
	public void updateBank(Bank bank) {
		entityTransaction.begin();
		entityManager.merge(bank);
		entityTransaction.commit();
	}
	
	public void updateAccount(Account account) {
		entityTransaction.begin();
		entityManager.merge(account);
		entityTransaction.commit();
	}
	
	public void deposit(long accno, double amount) {
		entityTransaction.begin();
		Account account=entityManager.find(Account.class, accno);
		if (account!=null) {
			account.deposit(amount);
			entityTransaction.commit();
		} else {
			System.out.println("Account not found");
		}
	}
	
	public void withdraw(long accno, double amount) {
		entityTransaction.begin();
		Account account=entityManager.find(Account.class, accno);
		if (account!=null) {
			account.withdraw(amount);
			entityTransaction.commit();
		} else {
			System.out.println("Account not found");
		}
	}
	
	public void findBank(String id) {
		entityTransaction.begin();
		Bank bank=entityManager.find(Bank.class, id);
		if (bank!=null) {
			System.out.println(bank);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		}
	}
	
	public void findAccount(long id) {
		entityTransaction.begin();
		Account account=entityManager.find(Account.class, id);
		if (account!=null) {
			System.out.println(account);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		}
	}
	
	public void deleteBank(String id) {
		entityTransaction.begin();
		Bank bank=entityManager.find(Bank.class, id);
		if (bank!=null) {
			entityManager.remove(bank);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		}
	}
	
	public void deleteAccount(long id) {
		entityTransaction.begin();
		Account account=entityManager.find(Account.class, id);
		if (account!=null) {
			entityManager.remove(account);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		}
	}
	
	public void listQueryBank() {
		Query query=entityManager.createQuery("select b from Bank b");
		List<Bank> b=query.getResultList();
		for (Bank bank : b) {
			System.out.println(bank);
		}
	}
	
	public void listQueryAccount() {
		Query query=entityManager.createQuery("select a from Account a");
		List<Account> a=query.getResultList();
		for (Account account : a) {
			System.out.println(account);
		}
	}
}
