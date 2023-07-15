package com.benkhalifa.ICINBank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.benkhalifa.ICINBank.model.Admin;


@Repository
public  interface AdminRepository extends JpaRepository<Admin, Long> {

	public Admin findByPassword(String password);
	public Admin findByEmail(String email);
	public Admin findByEmailAndPassword(String email,String password);

	

}
