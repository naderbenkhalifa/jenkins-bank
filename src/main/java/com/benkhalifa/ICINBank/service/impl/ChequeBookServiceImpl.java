package com.benkhalifa.ICINBank.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.benkhalifa.ICINBank.model.ChequeBook;
import com.benkhalifa.ICINBank.repo.ChequeBookRepository;
import com.benkhalifa.ICINBank.service.ChequeBookService;

@Service
public class ChequeBookServiceImpl implements ChequeBookService {
	
	@Autowired
	ChequeBookRepository checkbookRepository;

	

	@Override
	public List<ChequeBook> AllChequeBooks() {
		
		return checkbookRepository.findAll();
	}

	@Override
	public ChequeBook findChequebookById(Long id) {
		
		return checkbookRepository.findById(id).get() ;
	}

	@Override
	public void ChequeBookRequestTrue(Long id) {
		ChequeBook chequeBook=checkbookRepository.findById(id).get();
		chequeBook.setAccepted(true);
		checkbookRepository.save(chequeBook);
		
	}

	@Override
	public void ChequeBookRequestFalse(Long id) {
		ChequeBook chequeBook=checkbookRepository.findById(id).get();
		chequeBook.setAccepted(false);
		checkbookRepository.save(chequeBook);
		
	}

	@Override
	public ChequeBook create(ChequeBook chequebook) {
		
		return checkbookRepository.save(chequebook);
	}

}
