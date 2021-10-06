package com.saraya;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.saraya.domain.Customer;
import com.saraya.dto.CustomerDTO;
import com.saraya.repository.CustomerRepository;
import com.saraya.service.CustomerService;

@SpringBootApplication
public class PaginationDemoApplication implements CommandLineRunner{
    static Logger logger = Logger.getLogger(PaginationDemoApplication.class);
	@Autowired
			CustomerService service;
			
		@Autowired
		CustomerRepository repository;
		

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(PaginationDemoApplication.class, args);
	}
	
	@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1);
				CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2);
				CustomerDTO customer3= new CustomerDTO(7022713745L, "Andrew", 27, 'M', "New York", 2);
				CustomerDTO customer4= new CustomerDTO(7022713746L, "Diana", 25, 'F', "Alberta", 1);
				CustomerDTO customer5= new CustomerDTO(7022713747L, "Grace", 27, 'F', "Chicago", 1);
				
				
				service.insertCustomer(customer1);
				service.insertCustomer(customer2);
				service.insertCustomer(customer3);
				service.insertCustomer(customer4);
				service.insertCustomer(customer5);
		          
		        
		        int k=(int) (repository.count()/3);
		        for(int i=0;i<=k;i++){
	        Pageable pageable = PageRequest.of(i,3);
		        
		        logger.info("Records are: ");
		        Iterable<Customer> customer8 = service.findAll(pageable);
		        
		        for(Customer alist3 : customer8){
		             logger.info(alist3);
		        }
		        }
		        logger.info("Sorted records..");
			        
		       Iterable<Customer> customer8 = service.findAll(Sort.by(Sort.Direction.DESC,"name"));
		        
		        for(Customer alist3 : customer8){
		             logger.info(alist3);
		        }     
		        }
		
		}

	


