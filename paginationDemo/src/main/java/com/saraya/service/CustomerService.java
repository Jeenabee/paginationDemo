package com.saraya.service;

		import java.util.List;
		import org.springframework.data.domain.Page;
		import org.springframework.data.domain.Pageable;
		import org.springframework.data.domain.Sort;
		
		import com.saraya.domain.Customer;
		import com.saraya.dto.CustomerDTO;
		
		public interface CustomerService {
		
			public void insertCustomer(CustomerDTO Customer) ;
			Page<Customer> findAll(Pageable page);
			List<Customer> findAll(Sort sort);

}
