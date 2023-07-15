package com.benkhalifa.ICINBank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.benkhalifa.ICINBank.model.Transaction;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	
	 @Query("SELECT transaction FROM Transaction transaction "
	            + "WHERE transaction.sourceAccountNumber = ?1"
	            + "OR transaction.destinationAccountNumber = ?1")
	    List<Transaction> retrieveTransactionsForAccount(int accountId);
	
	 
	 

}
