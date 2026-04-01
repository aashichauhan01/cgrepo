package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Account;
import com.cg.exceptions.AccNotFoundException;
import com.cg.exceptions.InsufficientFundException;
import com.cg.repo.AccountRepo;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepo repo;
	
	
	@Override
	public boolean transferFund(Integer from, Integer to, Double amt) {

		Optional<Account> optFrom= repo.findById(from);
		if(optFrom.isEmpty())
			throw new AccNotFoundException("Account not found for"+from);
		Optional<Account> optTo= repo.findById(to);
		if(optTo.isEmpty())
			throw new AccNotFoundException("Account not found for"+to);

		Account fromAcc=optFrom.get();
		if(fromAcc.getAmt()<amt)
			throw new InsufficientFundException("Fund is low");
		Account toAcc=optTo.get();
		fromAcc.setAmt(fromAcc.getAmt()-amt);
		toAcc.setAmt(toAcc.getAmt()+amt);
		repo.save(fromAcc);
		repo.save(toAcc);
		return true;
	}

}
