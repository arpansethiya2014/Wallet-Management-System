package com.arpan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.arpan.entity.UserDetails;
import com.arpan.request.UserDetailsRequest;
import com.arpan.service.UserDetailsService;
import com.arpan.validation.ValidMobileNumber;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserDetailsController {

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/save")
	public String save(@Valid @RequestBody UserDetailsRequest detailsRequest) throws Exception {
		return userDetailsService.saveUsers(detailsRequest);
	}

	@GetMapping("/findAll")
	public List<UserDetails> findAll() throws Exception {
		return userDetailsService.findAll();
	}

	@GetMapping("/findWalletBalance")
	public String findWalletBalnace(@ValidMobileNumber @RequestParam String mobile) throws Exception {
		return userDetailsService.findWalletBalnace(mobile);
	}

	@PutMapping("/update/{id}")
	public String updateUserDetails(@PathVariable long id,@Valid @RequestBody UserDetailsRequest userDetailsRequest){
		return userDetailsService.updateUserDetails(id,userDetailsRequest);
	}

	@GetMapping("/findById")
	public ResponseEntity<UserDetails> findById(@RequestParam long id){
		UserDetails userDetails = userDetailsService.findById(id);
		return ResponseEntity.ok(userDetails);
	}

}
