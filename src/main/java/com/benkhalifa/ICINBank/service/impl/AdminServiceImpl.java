package com.benkhalifa.ICINBank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benkhalifa.ICINBank.model.Admin;
import com.benkhalifa.ICINBank.repo.AdminRepository;
import com.benkhalifa.ICINBank.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private  AdminRepository repo;

	@Override
	public Admin save(Admin admin) {
		
		return repo.save(admin);
	}

	@Override
	public List<Admin> getAll() {
	
		return repo.findAll();
	}

	@Override
	public Admin getAdminByPassword(String password) {
		
		return repo.findByPassword(password);
	}

	@Override
	public Admin getAdminByEmail(String email) {
		
		return repo.findByEmail(email);
	}

	@Override
	public Admin getAdminByEmailAndPassword(String email, String password) {
		
		return repo.findByEmailAndPassword(email, password);
	}

	@Override
	public void deleteAdminById(Long id) {
		repo.deleteById(id);
	
		
	}

	@Override
	public Admin getAdminById(Long id) {
		
		return repo.findById(id).get();
	}
	

}
