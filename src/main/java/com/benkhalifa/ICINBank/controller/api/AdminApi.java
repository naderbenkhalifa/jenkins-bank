package com.benkhalifa.ICINBank.controller.api;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.benkhalifa.ICINBank.model.Admin;
import com.benkhalifa.ICINBank.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("admins")
public interface AdminApi {
	@PostMapping(value =Constants.APP_ROOT + "/admins/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Register an administrator", notes = "This method allows you to register an administrator", response = Admin.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The administrator object is created"),
	      @ApiResponse(code = 400, message = "Administrator object is invalid")
	  })
	Admin save(@RequestBody Admin admin);
	@GetMapping(value = Constants.APP_ROOT + "/admins/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Returns the list of administrators", notes = "This method allows you to search and return the list of administrators that exist"
	      + "in the DB", responseContainer = "List<Admin>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of administrators / An empty list")
	  })
	  List<Admin> findAll();
	 @GetMapping(value =Constants.APP_ROOT+"/admins/{password}" , produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Search the list of administrators by password", notes = "This method allows to Search the list of administrators by password", response = Admin.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of administrators/empty list"),
	     
	  })
	Admin findByPassword(@PathVariable("password") String password);
	
	 
	 
	 @GetMapping(value =Constants.APP_ROOT+"/admins/find/{email}" , produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Search the list of administrators by email", notes = "This method allows to Search the list of administrators by email", response = Admin.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of administrators /empty list"),
	     
	  })
	 Admin findByEmail(@PathVariable("email") String email);

	 
	 
	 @DeleteMapping(value = Constants.APP_ROOT + "/admins/delete/{idadmin}")
	  @ApiOperation(value = "Delete an administrator", notes = "This method allows you to delete an administrator by ID")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "administrator has been deleted")
	  })
	  void delete(@PathVariable("idadmin") Long id);
	 
	 
	 
	 @GetMapping(value = Constants.APP_ROOT + "/admins/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Search for an administrator by ID", notes = "This method allows you to search for an administrator by his ID", response = Admin.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The administrator was found in the DB"),
	      @ApiResponse(code = 404, message = "No administrator exists in the DB with the provided ID")
	  })
	  Admin findById(@PathVariable("id") Long id);
	
	 
	 
	 @GetMapping(value = Constants.APP_ROOT + "/admins/get/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Find an administrator by email and password", notes = "This method allows you to search for an administrator by his email and password", response = Admin.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The administrator was found in the DB"),
	      @ApiResponse(code = 404, message = "No administrator exists in the database")
	  })
	  Admin findByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password);
	
	 
	 
	 
	 
	 


}
