
package com.benkhalifa.ICINBank.service;

import java.util.List;


import com.benkhalifa.ICINBank.model.PrimaryAccount;

public interface PrimaryAccountService {
	
	
	public PrimaryAccount createPrimaryAccount();
	public List<PrimaryAccount> getAllPrimaryAccounts();
	public Long withdraw(Integer accNo, Long amount);
	public Long deposit(Integer accNo, Long amount);
	public PrimaryAccount getAccount(int accNo);
	public Long retrieveAccountBalance(Long accountId);
	
	
	
	

}
