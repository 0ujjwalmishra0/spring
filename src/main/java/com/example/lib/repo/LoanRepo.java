package com.example.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lib.model.Loan;
import java.sql.Date;
public interface LoanRepo extends JpaRepository<Loan, Long>{
	
	public Loan findByBookIdAndUserId(long book_id,long user_id);
}
