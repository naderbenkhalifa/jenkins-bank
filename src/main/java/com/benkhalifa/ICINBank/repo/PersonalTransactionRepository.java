package com.benkhalifa.ICINBank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benkhalifa.ICINBank.model.PersonalTransaction;


@Repository
public interface PersonalTransactionRepository extends JpaRepository<PersonalTransaction,Long> {

}
