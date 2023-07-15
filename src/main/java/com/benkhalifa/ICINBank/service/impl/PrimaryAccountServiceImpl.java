package com.benkhalifa.ICINBank.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.benkhalifa.ICINBank.exception.AccountNotFoundException;
import com.benkhalifa.ICINBank.model.PersonalTransaction;
import com.benkhalifa.ICINBank.model.PrimaryAccount;
import com.benkhalifa.ICINBank.repo.PersonalTransactionRepository;
import com.benkhalifa.ICINBank.repo.PrimaryAccountRepository;
import com.benkhalifa.ICINBank.service.PrimaryAccountService;



@Service
public class PrimaryAccountServiceImpl implements PrimaryAccountService {
	@Autowired
	 private PrimaryAccountRepository primaryAccountRepository;
	   
	
	 @Autowired
	 private PersonalTransactionRepository personalTransactionRepository;
	 
	 private static int nextAccountNumber = 22113344;

	

	@SuppressWarnings("removal")
	@Override
	public PrimaryAccount createPrimaryAccount() {
		PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new Long(0));
        nextAccountNumber += 1;
        primaryAccount.setAccountNumber(nextAccountNumber);
        primaryAccountRepository.save(primaryAccount);
        return primaryAccountRepository.findByAccountNumber(primaryAccount.getAccountNumber());
	}

	@Override
	public List<PrimaryAccount> getAllPrimaryAccounts() {
		
		return primaryAccountRepository.findAll() ;
	}




	@Override
	public PrimaryAccount getAccount(int accNo) {
		
		return primaryAccountRepository.findByAccountNumber(accNo) ;
	}

	@Override
	public Long retrieveAccountBalance(Long accountId) {
		 Optional<PrimaryAccount> account = primaryAccountRepository.findById(accountId);
	        if (!account.isPresent()) {
	            throw new AccountNotFoundException(
	                  String.format("Account %s not found.", accountId));
	        }
	        return account.get().getAccountBalance();
	    }
	    
	



	@Override
	public Long deposit(Integer accNo, Long amount) {
		PrimaryAccount primaryAccount = primaryAccountRepository.findByAccountNumber(accNo);
      	Long prevBal = primaryAccount.getAccountBalance();
      	Long newBal = primaryAccount.getAccountBalance() + amount;
        primaryAccount.setAccountBalance(newBal );
        primaryAccountRepository.save(primaryAccount);
        
        Date date = new Date();
        PersonalTransaction personalTransaction = new PersonalTransaction(accNo ,date, prevBal , newBal, "Deposit" ,"Primary");
        personalTransactionRepository.save(personalTransaction);
        return  primaryAccount.getAccountBalance();
		
	}
	
	public Long withdraw(Integer accNo, Long amount) {
		PrimaryAccount primaryAccount = primaryAccountRepository.findByAccountNumber(accNo);
				
				if(primaryAccount.getAccountBalance()>=amount) {
					Long prevBal = primaryAccount.getAccountBalance();
					Long newBal = primaryAccount.getAccountBalance() - amount;
			        primaryAccount.setAccountBalance(newBal);
			        primaryAccountRepository.save(primaryAccount);
			        Date date = new Date();
			        PersonalTransaction personalTransaction = new PersonalTransaction(accNo ,date, prevBal, newBal, "Withdraw" ,"Primary");
			        personalTransactionRepository.save(personalTransaction);

			       
				} 
				return primaryAccount.getAccountBalance();
				}

	

	
	

}
