package com.benkhalifa.ICINBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.benkhalifa.ICINBank.controller.api.PrimaryAccountApi;
import com.benkhalifa.ICINBank.model.PrimaryAccount;
import com.benkhalifa.ICINBank.repo.PrimaryAccountRepository;
import com.benkhalifa.ICINBank.service.PrimaryAccountService;



@CrossOrigin(origins = "*")
@RestController
public class PrimaryAccountController implements PrimaryAccountApi  {
	
	@Autowired
	private PrimaryAccountService primaryAccountService;
	
	
	@Autowired
	private PrimaryAccountRepository primaryAccountRepository;
	
	
	
	@Override
	public PrimaryAccount save(PrimaryAccount primaryAccount) {
		
	return primaryAccountService.createPrimaryAccount() ;
	}
	

	@Override
	public List<PrimaryAccount> retrieveAllAccounts() {
		
		return primaryAccountRepository.findAll();
	}
	

	@Override
	public Long retrieveAccountBalance(int accountNumber) {
		
		 PrimaryAccount account = primaryAccountRepository.findByAccountNumber(accountNumber);
			return account.getAccountBalance();
	}
	

	@Override
	public Long withdraw(Integer accNo, Long amount) {
		
		return primaryAccountService.withdraw(accNo,amount);
	}
	

	@Override
	public Long deposit(Integer accNo, Long amount) {
		
		return primaryAccountService.deposit(accNo,amount );
	}


	@Override
	public PrimaryAccount getAccountByAccountNumber(Integer accNo) {
		
		return primaryAccountService.getAccount(accNo);
	}

}
