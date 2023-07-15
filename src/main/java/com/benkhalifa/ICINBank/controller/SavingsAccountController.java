package com.benkhalifa.ICINBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.benkhalifa.ICINBank.controller.api.SavingsAccountApi;
import com.benkhalifa.ICINBank.model.SavingsAccount;
import com.benkhalifa.ICINBank.repo.SavingsAccountRepository;
import com.benkhalifa.ICINBank.service.SavingsAccountService;


@CrossOrigin(origins = "*")
@RestController
public class SavingsAccountController implements SavingsAccountApi  {
	
	
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	
	
	@Autowired
	private SavingsAccountRepository savingsAccountRepository;
	
	

	
	
	@Override
	public SavingsAccount save(SavingsAccount SavingsAccount) {
		
		return savingsAccountService.createSavingsAccount();
	}

	@Override
	public List<SavingsAccount> retrieveAllAccounts() {
		
		return savingsAccountRepository.findAll();
	}

	@Override
	public Long retrieveAccountBalance(int accountNumber) {
		
		SavingsAccount account = savingsAccountRepository.findByAccountNumber(accountNumber);
		return account.getAccountBalance();
	}

	@Override
	public Long withdraw(Integer accNo, Long amount) {
		
		return savingsAccountService.withdraw(accNo, amount) ;
	}

	@Override
	public Long deposit(Integer accNo, Long amount) {
		
		return savingsAccountService.deposit(accNo, amount);
	}

	@Override
	public SavingsAccount getAccountByAccountNumber(Integer accNo) {
		
		return savingsAccountService.getAccount(accNo) ;
	}

}
