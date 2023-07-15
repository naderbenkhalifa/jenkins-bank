package com.benkhalifa.ICINBank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.benkhalifa.ICINBank.controller.api.TransactionApi;
import com.benkhalifa.ICINBank.model.Transaction;
import com.benkhalifa.ICINBank.service.TransactionService;

@CrossOrigin(origins = "*")
@RestController
public class TransactionController implements TransactionApi {
	
	  @Autowired
	    private TransactionService transactionService;

	@Override
	public Object transferMoney(Transaction transaction) {
		
		  transactionService.transferMoney(transaction);
		
		
		
		return transaction  ;
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		
		return transactionService.createTransaction(transaction);
	}

	@Override
	public List<Transaction> retrieveAccountTransactions(int accountId) {
		
		return transactionService.retrieveTransactionsForAccount(accountId);
	}

}
