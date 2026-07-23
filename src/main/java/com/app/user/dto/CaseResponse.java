package com.app.user.dto;

import java.util.UUID;

public record CaseResponse(UUID caseId, String status) {
}