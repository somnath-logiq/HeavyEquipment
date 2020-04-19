package com.logiq.heavyequipment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logiq.heavyequipment.domain.request.UserRequest;
import com.logiq.heavyequipment.domain.response.UserResponse;
import com.logiq.heavyequipment.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

	
	@Autowired
	UserService userService;
	
    @ApiOperation(value = "View a list of available employees", response = UserResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved user"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    
	@PostMapping
	public Mono<Void> createUser(@Valid @RequestBody UserRequest userRequest) {
		log.info("userRequest: {}", userRequest);
    	userService.save(userRequest.getUser());
		return Mono.justOrEmpty(null);
	}
    
    @GetMapping
	public Mono<UserResponse> get(@RequestParam(value = "firstName") String firstName) {
		UserResponse useResponse = new UserResponse();
		useResponse.setUser(userService.get(firstName));
		return Mono.justOrEmpty(useResponse);
	}

}
