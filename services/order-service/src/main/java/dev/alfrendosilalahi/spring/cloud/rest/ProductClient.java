package dev.alfrendosilalahi.spring.cloud.rest;

import dev.alfrendosilalahi.spring.cloud.dto.PurchaseRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.PurchaseResponseDTO;
import dev.alfrendosilalahi.spring.cloud.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;

    private final RestTemplate restTemplate;

    public List<PurchaseResponseDTO> purchaseProducts(List<PurchaseRequestDTO> purchaseRequestDTOList) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequestDTO>> requestEntity = new HttpEntity<>(purchaseRequestDTOList, headers);
        ParameterizedTypeReference<List<PurchaseResponseDTO>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<PurchaseResponseDTO>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
        );
        if (responseEntity.getStatusCode().isError()) {
            throw new BusinessException("an error occur while processing the products purchase :: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }

}
