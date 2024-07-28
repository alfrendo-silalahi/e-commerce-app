package dev.alfrendosilalahi.spring.cloud.dto;

import java.util.Map;

public record ErrorResponseDTO(
    Map<String, String> error
) {}
