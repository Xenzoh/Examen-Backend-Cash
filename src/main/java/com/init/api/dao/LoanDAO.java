package com.init.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.api.entidades.Loan;

public interface LoanDAO extends JpaRepository<Loan, Long>{
	

}
