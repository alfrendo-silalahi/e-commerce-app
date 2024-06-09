package me.alfrendosilalahi.ecommerce.customer_service.service;

import me.alfrendosilalahi.ecommerce.customer_service.dto.CustomerRequestDTO;
import me.alfrendosilalahi.ecommerce.customer_service.dto.CustomerResponseDTO;
import java.util.List;

public interface ICustomerService {

  String createCustomer(CustomerRequestDTO customerRequestDTO);

  void updateCustomer(CustomerRequestDTO customerRequestDTO);

  List<CustomerResponseDTO> findAllCustomers();

  boolean existById(String customerId);

  CustomerResponseDTO findCustomerById(String customerId);

  void createCustomer(String customerId);
    
}
