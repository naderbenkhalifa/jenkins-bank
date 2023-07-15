package com.benkhalifa.ICINBank.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.benkhalifa.ICINBank.model.PrimaryAccount;
import com.benkhalifa.ICINBank.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("parimaryAccounts")
public interface PrimaryAccountApi {
	@PostMapping(value =Constants.APP_ROOT + "/primary-account/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Register primary-account", notes = "This method allows you to register primary-account", response =  PrimaryAccount.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The  primary-account is created"),
	      @ApiResponse(code = 400, message = "primary-account object is invalid")
	  })
	PrimaryAccount save(@RequestBody PrimaryAccount primaryAccount);
	
	@GetMapping(value = Constants.APP_ROOT + "/accounts/primary", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = " return List of  available primary accounts in the system", notes = "This method allows to return all available primary accounts in the system"
	    , responseContainer = "List<PrimaryAccount>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of primaryAccount / An empty list")
	  })
	 List<PrimaryAccount> retrieveAllAccounts();
	
	@GetMapping(value = Constants.APP_ROOT + "/accounts/primary/{accountNumber}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Find the balance available for a given primary account", notes = "This method allows to find the balance available for a given primary account"
	      )
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "balance value")
	  })
	public Long retrieveAccountBalance(@PathVariable int accountNumber);
	
	@GetMapping(value = Constants.APP_ROOT + "/withdraw/primary/{accNo}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "withdraw of amount from an primary account", notes = "This method allows to withdraw of amount from an primary account"
	     )
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "the operation is performed successfully")
	  })
Long withdraw( @PathVariable Integer accNo, @PathVariable Long amount);
	
	@GetMapping(value = Constants.APP_ROOT + "/deposit/primary/{accNo}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "deposit amount into primary account", notes = "This method allows to deposit amount into primary account"
	     )
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "the operation is performed successfully")
	  })
	Long deposit( @PathVariable Integer accNo, @PathVariable Long amount); 
	
	
	@GetMapping(value = Constants.APP_ROOT + "/find/primary/{accNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "find primary account by account Number", notes = "This method allows to find primary account by account Number", response = PrimaryAccount.class
	     )
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "primary account was found in DB")
	  })
	PrimaryAccount  getAccountByAccountNumber( @PathVariable Integer accNo); 
	

}
