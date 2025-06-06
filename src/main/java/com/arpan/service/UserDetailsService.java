package com.arpan.service;

import java.util.List;

import com.arpan.entity.UserDetails;
import com.arpan.request.UserDetailsRequest;
import jakarta.validation.Valid;

public interface UserDetailsService {

	String saveUsers(UserDetailsRequest detailsRequest) throws Exception;

	List<UserDetails> findAll() throws Exception;

	String findWalletBalnace(String mobile);

	String updateUserDetails(long id, UserDetailsRequest userDetailsRequest);

	UserDetails findById(long id);
}
