package com.benkhalifa.ICINBank.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.benkhalifa.ICINBank.model.SavingsAccount;
import com.benkhalifa.ICINBank.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("savingAccounts")
public interface SavingsAccountApi {
	
	@PostMapping(value =Constants.APP_ROOT + "/saving-account/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Register saving-account", notes = "This method allows you to register saving-account", response =  SavingsAccount.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The  saving-account is created"),
	      @ApiResponse(code = 400, message = "saving-account object is invalid")
	  })
	SavingsAccount save(@RequestBody  SavingsAccount SavingsAccount);
	
	@GetMapping(value = Constants.APP_ROOT + "/accounts/saving", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = " return List of  available saving accounts in the system", notes = "This method allows to return all available saving accounts in the system"
	    , responseContainer = "List<SavingsAccount>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of Saving Accounts / An empty list")
	  })
	 List<SavingsAccount> retrieveAllAccounts();
	
	@GetMapping(value = Constants.APP_ROOT + "/accounts/saving/{accountNumber}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Find the balance available for a given saving account", notes = "This method allows to find the balance available for a given saving account"
	      )
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "balance value")
	  })
	public Long retrieveAccountBalance(@PathVariable int accountNumber);
	
	@GetMapping(value = Constants.APP_ROOT + "/withdraw/saving/{accNo}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "withdraw of amount from an saving account", notes = "This method allows to withdraw of amount from an saving account"
	     )
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "the operation is performed successfully")
	  })
Long withdraw( @PathVariable Integer accNo, @PathVariable Long amount);
	
	@GetMapping(value = Constants.APP_ROOT + "/deposit/saving/{accNo}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "deposit amount into saving account", notes = "This method allows to deposit amount into saving account"
	     )
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "the operation is performed successfully")
	  })
	Long deposit( @PathVariable Integer accNo, @PathVariable Long amount); 
	
	@GetMapping(value = Constants.APP_ROOT + "/find/saving/{accNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "find saving account by account Number", notes = "This method allows to find saving account by account Number", response = SavingsAccount.class
	     )
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "saving account was found in DB")
	  })
	SavingsAccount  getAccountByAccountNumber( @PathVariable Integer accNo); 
	
	

}
