package com.benkhalifa.ICINBank.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.benkhalifa.ICINBank.model.Transaction;
import com.benkhalifa.ICINBank.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("transactions")
public interface TransactionApi {
	
	@PostMapping(value =Constants.APP_ROOT + "/transfer/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "register a transfer", notes = "This method allows you to register a transfer", response = Object.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The transfer object is created"),
	      @ApiResponse(code = 400, message = "The transfer object is invalid")
	  })
	
	Object transferMoney(@RequestBody Transaction transaction);
	
	
	@PostMapping(value =Constants.APP_ROOT + "/transactions/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "register a trnsaction", notes = "This method allows you to register a transaction", response = Transaction.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The transaction object is created"),
	      @ApiResponse(code = 400, message = "The transaction object is invalid")
	  })
	
	Transaction createTransaction(@RequestBody Transaction transaction);
	
	@GetMapping(value = Constants.APP_ROOT + "/accounts/{accountId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "return List of transactions for a given bank account", notes = "This method allows to  return List of transactions for a given bank account "
	      + "in the DB", responseContainer = "List<Transaction>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of transactions / An empty list")
	  })
	  public List<Transaction> retrieveAccountTransactions(@PathVariable int accountId);

}
