package com.benkhalifa.ICINBank.controller.api;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.benkhalifa.ICINBank.model.User;
import com.benkhalifa.ICINBank.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("users")
public interface UserApi {
	@PostMapping(value =Constants.APP_ROOT + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Register a user", notes = "This method allows you to register a user", response = User.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The user object is created"),
	      @ApiResponse(code = 400, message = "User object is invalid")
	  })
	 User save(@RequestBody User user);
	@GetMapping(value = Constants.APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Returns the list of users", notes = "This method allows to search and return the list of users that exist"
	      + "in the DB", responseContainer = "List<User>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of users / An empty list")
	  })
	  List<User> findAll();
	 @GetMapping(value =Constants.APP_ROOT+"/users/{password}" , produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Search the list of users by password", notes = "This method allows to Search the list of users by password", response = User.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of users /empty list"),
	     
	  })
	 User findByPassword(@PathVariable("password") String password);
	 
	 
	 @GetMapping(value =Constants.APP_ROOT+"/user/find/{email}" , produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Search the list of users by email", notes = "This method allows to Search the list of users by email", response = User.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The list of users/empty list"),
	     
	  })
	 User findByEmail(@PathVariable("email") String email);
	 
	 
	 @DeleteMapping(value = Constants.APP_ROOT + "/users/delete/{iduser}")
	  @ApiOperation(value = "Delete a user", notes = "This method allows you to delete a user by ID")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "user has been deleted")
	  })
	  void delete(@PathVariable("iduser") Long id);
	 
	 
	 @GetMapping(value = Constants.APP_ROOT + "/users/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Find a user by ID", notes = "This method allows you to search for a user by his ID", response = User.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "User was found in DB"),
	      @ApiResponse(code = 404, message = "No user exists in the DB with the provided ID")
	  })
	  User findById(@PathVariable("id") Long id);
	 
	 
	 @GetMapping(value = Constants.APP_ROOT + "/users/get/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Search for a user by email and password", notes = "This method allows you to search for a user by his email and password", response = User.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "User was found in DB"),
	      @ApiResponse(code = 404, message = "No user exists in the DB")
	  })
	  User findByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password);
	 
	 @PostMapping(value =Constants.APP_ROOT + "/users/login/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Register userlogin", notes = "This method allows to save a userlogin", response = User.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "The userlogin object is created"),
	      @ApiResponse(code = 400, message = "Userlogin object is invalid")
	  })
	 User addUserLogin (@RequestBody User user) throws Exception ;

	 
	 
	 


}
