package com.arpan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
