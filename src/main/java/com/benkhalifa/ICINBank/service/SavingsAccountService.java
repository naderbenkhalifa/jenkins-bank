package com.benkhalifa.ICINBank.service;

import java.util.List;

import com.benkhalifa.ICINBank.model.SavingsAccount;

public interface SavingsAccountService {
	

	public SavingsAccount createSavingsAccount();
	public List<SavingsAccount> getAllSavingsAccounts();
	public Long deposit(Integer accNo, Long amount);
	public Long withdraw(Integer accNo, Long amount);
    public SavingsAccount getAccount(int accNo);
	public Long retrieveAccountBalance(Long accountId);

}
