package com.benkhalifa.ICINBank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.benkhalifa.ICINBank.model.SavingsAccount;


@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
	
	 SavingsAccount findByAccountNumber (int accountNumber);

}
