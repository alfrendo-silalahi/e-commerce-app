package me.alfrendosilalahi.ecommerce.customer_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.alfrendosilalahi.ecommerce.customer_service.service.ICustomerService;
import me.alfrendosilalahi.ecommerce.customer_service.dto.CustomerRequestDTO;
import me.alfrendosilalahi.ecommerce.customer_service.dto.CustomerResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    
    private final ICustomerService customerService;

    @PostMapping()
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

    @PutMapping()
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.accepted().build();
    }

    @GetMapping()
    public ResponseEntity<List<CustomerResponseDTO>> findAll() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{customer_id}/exist")
    public ResponseEntity<Boolean> existsById(@PathVariable("customer_id") String customerId) {
        return ResponseEntity.ok(customerService.existById(customerId));
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerResponseDTO> findCustomerById(@PathVariable("customer_id") String customerId) {
        return ResponseEntity.ok(customerService.findCustomerById(customerId));
    }

    @DeleteMapping("/{customer_id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customer_id") String customerId) {
        customerService.createCustomer(customerId);
        return ResponseEntity.accepted().build();
    }

}
