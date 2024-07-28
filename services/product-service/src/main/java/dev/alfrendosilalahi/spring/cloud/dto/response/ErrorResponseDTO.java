package dev.alfrendosilalahi.spring.cloud.dto.response;

import java.util.Map;

public record ErrorResponseDTO(
        Map<String, String> error
) {
}
