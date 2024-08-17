package com.microservice.email.domain.dtos;

import java.util.UUID;

public record EmailDTO(UUID id, String emailTo, String subject, String text) {
}
