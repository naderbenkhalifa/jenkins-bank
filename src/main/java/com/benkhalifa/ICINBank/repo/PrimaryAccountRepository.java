package com.benkhalifa.ICINBank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.benkhalifa.ICINBank.model.PrimaryAccount;

@Repository
public interface PrimaryAccountRepository extends JpaRepository<PrimaryAccount, Long>{
	
	 PrimaryAccount findByAccountNumber (int accountNumber);

}
