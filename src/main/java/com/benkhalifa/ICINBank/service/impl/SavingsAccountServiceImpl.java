package com.benkhalifa.ICINBank.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.benkhalifa.ICINBank.exception.AccountNotFoundException;
import com.benkhalifa.ICINBank.model.PersonalTransaction;
import com.benkhalifa.ICINBank.model.SavingsAccount;
import com.benkhalifa.ICINBank.repo.PersonalTransactionRepository;
import com.benkhalifa.ICINBank.repo.SavingsAccountRepository;
import com.benkhalifa.ICINBank.service.SavingsAccountService;


@Service
public class SavingsAccountServiceImpl implements SavingsAccountService  {
	
	 @Autowired
	    private SavingsAccountRepository savingsAccountRepository;
	    
	    private static int nextAccountNumber = 11223344;
		
		
		@Autowired
		private PersonalTransactionRepository personalTransactionRepository;

	@SuppressWarnings("removal")
	@Override
	public SavingsAccount createSavingsAccount() {
		 SavingsAccount savingsAccount = new SavingsAccount();
	        savingsAccount.setAccountBalance(new Long(0));
	        nextAccountNumber += 1;
	        savingsAccount.setAccountNumber(nextAccountNumber);
	        System.out.println(savingsAccount);
	        savingsAccountRepository.save(savingsAccount);

	        return savingsAccountRepository.findByAccountNumber(savingsAccount.getAccountNumber());
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccounts() {
		
		return savingsAccountRepository.findAll() ;
	}

	
	
	@Override
	public SavingsAccount getAccount(int accNo) {
		
		return savingsAccountRepository.findByAccountNumber(accNo) ;
	}

	@Override
	public Long retrieveAccountBalance(Long accountId) {
		
		 Optional<SavingsAccount> account = savingsAccountRepository.findById(accountId);
	        if (!account.isPresent()) {
	            throw new AccountNotFoundException(
	                  String.format("Account %s not found.", accountId));
	        }
	        return account.get().getAccountBalance();
		
	}
	
	@Override
	public Long deposit(Integer accNo, Long amount) {
		SavingsAccount savingsAccount = savingsAccountRepository.findByAccountNumber(accNo);
      	Long prevBal = savingsAccount.getAccountBalance();
      	Long newBal = savingsAccount.getAccountBalance() + amount;
        savingsAccount.setAccountBalance(newBal);
        savingsAccountRepository.save(savingsAccount);
        
        Date date = new Date();
        PersonalTransaction personalTransaction = new PersonalTransaction(accNo ,date, prevBal , newBal, "Deposit" ,"Saving");
        personalTransactionRepository.save(personalTransaction);
        return  savingsAccount.getAccountBalance();
		
	}

	@Override
	public Long withdraw(Integer accNo, Long amount) {
		
		SavingsAccount savingsAccount = savingsAccountRepository.findByAccountNumber(accNo);
		
		if(savingsAccount.getAccountBalance()>=amount) {
			Long prevBal = savingsAccount.getAccountBalance();
			Long newBal = savingsAccount.getAccountBalance() - amount;
	        savingsAccount.setAccountBalance(newBal);
	        savingsAccountRepository.save(savingsAccount);
	        Date date = new Date();
	        PersonalTransaction personalTransaction = new PersonalTransaction(accNo ,date, prevBal, newBal, "Withdraw" ,"saving");
	        personalTransactionRepository.save(personalTransaction);

	       
		} 
		return savingsAccount.getAccountBalance();
	}

}
