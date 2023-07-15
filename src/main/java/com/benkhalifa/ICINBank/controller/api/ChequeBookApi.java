package com.benkhalifa.ICINBank.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.benkhalifa.ICINBank.model.ChequeBook;
import com.benkhalifa.ICINBank.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("chequeBooks")
public interface ChequeBookApi {
	
	@PostMapping(value =Constants.APP_ROOT + "/chequeBooks/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "create a cheque-book", notes = "This method is used to create a cheque-book", response = ChequeBook.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The Cheque-book object is created"),
	      @ApiResponse(code = 400, message = "The Cheque-book  object is invalid")
	  })
	
	
	ChequeBook create(@RequestBody ChequeBook chequebook);
	
	
	
	
	@GetMapping(value = Constants.APP_ROOT + "/chequeBooks/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Returns the list of Cheque-books", notes = "this method allows you to search and return the list of Cheque-books  that exist"
	      + "in the DB", responseContainer = "List<ChequeBook>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of Cheque-books / An empty list")
	  })
	List<ChequeBook> AllChequeBooks();
	
	
	 @GetMapping(value = Constants.APP_ROOT + "/chequeBooks/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Search a cheque-book by ID", notes = "This method allows you to search for a cheque-book by its ID", response = ChequeBook.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "cheque-book was found in the database"),
	      @ApiResponse(code = 404, message = "No cheque-book exists in the database with the provided ID")
	  })
	  ChequeBook findById(@PathVariable("id") Long id);
	 
	 
	 @GetMapping(value = Constants.APP_ROOT + "/admins/confirmChequeTrue/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "confirm a  cheque-book by ID", notes = "This method allows you to confirm a cheque-book book by its ID")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "cheque-book has been confirmed"),
	      
	  })
	 public void ChequeBookRequestTrue(@PathVariable("id") Long id);
	 
	 
	 @GetMapping(value = Constants.APP_ROOT + "/admins/confirmChequeFalse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "refuse a cheque-book by ID", notes = "This method allows you to refuse a cheque-book by its ID")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "cheque-book has been refused"),
	      
	  })
	 public void ChequeBookRequestFalse(@PathVariable("id") Long id);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	 
	 


}
