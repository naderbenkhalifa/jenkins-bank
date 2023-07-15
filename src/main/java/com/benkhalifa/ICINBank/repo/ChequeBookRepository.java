package com.benkhalifa.ICINBank.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.benkhalifa.ICINBank.model.ChequeBook;

@Repository
public interface ChequeBookRepository extends JpaRepository<ChequeBook, Long> {
	
	
}
