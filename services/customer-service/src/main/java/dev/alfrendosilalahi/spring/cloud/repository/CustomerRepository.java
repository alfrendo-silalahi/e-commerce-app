package dev.alfrendosilalahi.spring.cloud.repository;

import dev.alfrendosilalahi.spring.cloud.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>{
    
}
