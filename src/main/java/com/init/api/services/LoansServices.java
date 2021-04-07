package com.init.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.init.api.dao.LoanDAO;
import com.init.api.entidades.Loan;

@RestController
@RequestMapping("loans")
public class LoansServices {

	@Autowired
	private LoanDAO loanDao;
	
	@GetMapping
	public Page<Loan> findAll(@RequestParam Optional<Integer> page,
			@RequestParam Optional<Integer> size){
		
		return loanDao.findAll(PageRequest.of(page.orElse(0),size.orElse(5)));
		
	}
}
