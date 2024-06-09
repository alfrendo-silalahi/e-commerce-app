package me.alfrendosilalahi.ecommerce.customer_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import me.alfrendosilalahi.ecommerce.customer_service.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
    
}
