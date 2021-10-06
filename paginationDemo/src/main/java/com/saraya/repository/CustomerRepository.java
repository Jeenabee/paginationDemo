package com.saraya.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	
	import com.saraya.domain.Customer;
	
	public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	}

