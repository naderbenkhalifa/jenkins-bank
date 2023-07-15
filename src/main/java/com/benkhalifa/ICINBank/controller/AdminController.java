package com.benkhalifa.ICINBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.benkhalifa.ICINBank.controller.api.AdminApi;
import com.benkhalifa.ICINBank.model.Admin;
import com.benkhalifa.ICINBank.service.AdminService;


@CrossOrigin(origins = "*")
@RestController
public class AdminController implements AdminApi {
	
	@Autowired
	private AdminService service;

	@Override
	public Admin save(Admin admin) {
		
		return service.save(admin);
	}

	@Override
	public List<Admin> findAll() {
		
		return service.getAll();
	}

	@Override
	public Admin findByPassword(String password) {
		
		return service.getAdminByPassword(password);
	}

	@Override
	public Admin findByEmail(String email) {
		
		return service.getAdminByEmail(email);
	}

	@Override
	public void delete(Long id) {
	service.deleteAdminById(id);;
		
	}

	@Override
	public Admin findById(Long id) {
		
		return service.getAdminById(id);
	}

	@Override
	public Admin findByEmailAndPassword(String email, String password) {
		
		return service.getAdminByEmailAndPassword(email, password);
	}
	

}
