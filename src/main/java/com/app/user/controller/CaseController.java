package com.app.user.controller;

import com.app.user.dto.AcceptCaseRequest;
import com.app.user.dto.CaseResponse;
import com.app.user.service.CaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cases")
public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping("/{caseId}/events/accept")
    public ResponseEntity<CaseResponse> acceptCase(@PathVariable String caseId, @RequestBody AcceptCaseRequest request) {
        CaseResponse response = caseService.acceptCase(request);
        return ResponseEntity.ok(response);
    }
}