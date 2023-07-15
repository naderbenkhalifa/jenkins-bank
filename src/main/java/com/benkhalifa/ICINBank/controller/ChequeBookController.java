package com.benkhalifa.ICINBank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.benkhalifa.ICINBank.controller.api.ChequeBookApi;
import com.benkhalifa.ICINBank.model.ChequeBook;
import com.benkhalifa.ICINBank.service.ChequeBookService;

@CrossOrigin(origins = "*")
@RestController
public class ChequeBookController implements ChequeBookApi {
	
	@Autowired
	private ChequeBookService service;

	

	@Override
	public List<ChequeBook> AllChequeBooks() {
		
		return service.AllChequeBooks();
	}

	@Override
	public ChequeBook findById(Long id) {
		
		return service.findChequebookById(id);
	}

	@Override
	public void ChequeBookRequestTrue(Long id) {
		service.ChequeBookRequestTrue(id);
		
	}

	@Override
	public void ChequeBookRequestFalse(Long id) {
		service.ChequeBookRequestFalse(id);
		
	}

	@Override
	public ChequeBook create(ChequeBook chequebook) {
		
		return service.create(chequebook);
	}

}
