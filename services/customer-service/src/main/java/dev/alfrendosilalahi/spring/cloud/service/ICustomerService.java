package dev.alfrendosilalahi.spring.cloud.service;

import dev.alfrendosilalahi.spring.cloud.dto.CustomerRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.CustomerResponseDTO;
import java.util.List;

public interface ICustomerService {

  String createCustomer(CustomerRequestDTO customerRequestDTO);

  void updateCustomer(CustomerRequestDTO customerRequestDTO);

  List<CustomerResponseDTO> findAllCustomers();

  boolean existById(String customerId);

  CustomerResponseDTO findCustomerById(String customerId);

  void createCustomer(String customerId);
    
}
