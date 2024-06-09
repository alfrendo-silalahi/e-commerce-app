package me.alfrendosilalahi.ecommerce.customer_service.model;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class Address {
    
    private String street;

    private String houseNumber;

    private String zipCode;

}
