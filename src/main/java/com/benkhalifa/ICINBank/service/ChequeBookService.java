package com.benkhalifa.ICINBank.service;

import java.util.List;
import com.benkhalifa.ICINBank.model.ChequeBook;

public interface ChequeBookService {
	
	
	public List<ChequeBook> AllChequeBooks();
	public ChequeBook findChequebookById(Long id);
	public void ChequeBookRequestTrue(Long id);
	public void ChequeBookRequestFalse(Long id);
	public ChequeBook create(ChequeBook chequebook);
	

}
