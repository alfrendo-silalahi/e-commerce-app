package dev.alfrendosilalahi.spring.cloud.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import dev.alfrendosilalahi.spring.cloud.service.ICustomerService;
import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import dev.alfrendosilalahi.spring.cloud.dto.CustomerRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.CustomerResponseDTO;
import dev.alfrendosilalahi.spring.cloud.repository.CustomerRepository;
import dev.alfrendosilalahi.spring.cloud.mapper.CustomerMapper;
import dev.alfrendosilalahi.spring.cloud.model.Customer;
import dev.alfrendosilalahi.spring.cloud.exception.CustomerNotFoundException;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public String createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerRepository.save(customerMapper.toCustomer(customerRequestDTO));
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerRepository.findById(customerRequestDTO.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("cannot update customer :: no custumer found with provided id :: %s", customerRequestDTO.id())
                ));
        mergeCustomer(customer, customerRequestDTO);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequestDTO customerRequestDTO) {
        if (StringUtils.isNotBlank(customerRequestDTO.firstName())) {
            customer.setFirstName(customerRequestDTO.firstName());
        }
        if (StringUtils.isNotBlank(customerRequestDTO.lastName())) {
            customer.setLastName(customerRequestDTO.lastName());
        }
        if (StringUtils.isNotBlank(customerRequestDTO.email())) {
            customer.setEmail(customerRequestDTO.email());
        }
        if (customerRequestDTO.address() != null) {
            customer.setAddress(customerRequestDTO.address());
        }
    }

    @Override
    public List<CustomerResponseDTO> findAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::fromCustomer).collect(Collectors.toList());
    }

    @Override
    public boolean existById(String customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    @Override
    public CustomerResponseDTO findCustomerById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("cannot update customer :: no custumer found with provided id :: %s", customerId)));
    }

    @Override
    public void createCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
    
}
