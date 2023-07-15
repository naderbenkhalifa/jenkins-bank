package com.benkhalifa.ICINBank.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.benkhalifa.ICINBank.exception.InvalidAccountException;
import com.benkhalifa.ICINBank.model.PrimaryAccount;
import com.benkhalifa.ICINBank.model.Transaction;
import com.benkhalifa.ICINBank.repo.PrimaryAccountRepository;
import com.benkhalifa.ICINBank.repo.TransactionRepository;
import com.benkhalifa.ICINBank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private PrimaryAccountRepository primaryAccountRepository;
    
    

	@Override
	public void transferMoney(Transaction transaction) {
		 PrimaryAccount sourceAccount = 
	        		primaryAccountRepository.findByAccountNumber(transaction.getSourceAccountNumber());
	        PrimaryAccount destinationAccount = 
	        		primaryAccountRepository.findByAccountNumber(transaction.getDestinationAccountNumber());
	        if (sourceAccount==null || destinationAccount==null) {
	            throw new InvalidAccountException(
	                    "Invalid source account " + "or destination account ");
	        }

	        transaction.runValidationTests(
	                sourceAccount, destinationAccount);

	        Long transactionAmount = 
	                transaction.getTransactionAmount();
	        sourceAccount.setAccountBalance(
	                sourceAccount.getAccountBalance() - transactionAmount); 
	        destinationAccount.setAccountBalance(
	                destinationAccount.getAccountBalance() + transactionAmount); 

	        transactionRepository.save(transaction);

	        primaryAccountRepository.save(sourceAccount);
	        primaryAccountRepository.save(destinationAccount);
		
		
	}

	@Override
	public int retreiveAccountNumber(Long id) {
		Optional<PrimaryAccount> account =  primaryAccountRepository.findById(id);
		int accNo = account.get().getAccountNumber();
		return accNo;
		
	}

	@Override
	public List<Transaction> retrieveTransactionsForAccount(int accountNumber) {
		
		return transactionRepository.retrieveTransactionsForAccount(accountNumber);
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		
		return transactionRepository.save(transaction);
	}
	
}
