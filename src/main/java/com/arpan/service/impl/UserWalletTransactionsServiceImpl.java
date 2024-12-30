package com.arpan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpan.entity.UserWalletTransactions;
import com.arpan.repo.UserDetailsRepository;
import com.arpan.repo.UserWalletTransactionsRepository;
import com.arpan.request.UserWalletRequest;
import com.arpan.service.UserWalletTransactionsService;
import com.arpan.utils.DateAndTime;
import com.arpan.wallet.WalletRequest;
import com.arpan.wallet.WalletService;

@Service
public class UserWalletTransactionsServiceImpl implements UserWalletTransactionsService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private WalletService walletService;

	@Autowired
	private UserWalletTransactionsRepository userWalletTransactionsRepository;

	@Override
	public String storeTransactions(UserWalletRequest userWalletRequest) {

		if (!userWalletRequest.getTransactionType().equals("Credit")
				&& !userWalletRequest.getTransactionType().equals("Debit")) {
			return "Transaction Type not supported Please enter Credit or Debit type";
		}

		if (!userDetailsRepository.existsById(userWalletRequest.getUserId())) {
			return "User not found";
		}

		String trxnId = "TRXN" + DateAndTime.getAlphaNumericString(10);
		String walletTrxnId = "WAL" + DateAndTime.getAlphaNumericString(10);
		WalletRequest walletRequest = new WalletRequest(userWalletRequest.getUserId(), userWalletRequest.getAmount(),
				userWalletRequest.getTransactionType(), userWalletRequest.getDescription(), trxnId, walletTrxnId);
		walletService.enqueueTransaction(walletRequest);

		return "Transaction Amount " + userWalletRequest.getTransactionType() + " : " + trxnId;
	}

	@Override
	public Object findUserId(long userId) {

		if (!userDetailsRepository.existsById(userId)) {
			return "User not found";
		}

		List<UserWalletTransactions> list = userWalletTransactionsRepository.findByUserId(userId);
          
		
		return list;
	}

}
