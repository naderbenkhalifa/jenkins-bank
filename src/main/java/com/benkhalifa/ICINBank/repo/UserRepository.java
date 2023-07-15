package com.benkhalifa.ICINBank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.benkhalifa.ICINBank.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByFullName(String fullName);
	public User findByPassword(String password);
	public User findByEmail(String email);
	public User findByEmailAndPassword(String email,String password);

}
