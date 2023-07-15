package com.benkhalifa.ICINBank.service;

import java.util.List;

import com.benkhalifa.ICINBank.model.Admin;



public interface AdminService {
	public Admin save(Admin admin);
	public List<Admin> getAll();
	public Admin getAdminByPassword(String password);
	public Admin getAdminByEmail(String email);
	public Admin getAdminByEmailAndPassword(String email,String password);
	public void deleteAdminById(Long id);
	public Admin getAdminById(Long id);

}
