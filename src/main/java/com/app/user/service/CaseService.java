package com.app.user.service;

import com.app.user.dto.AcceptCaseRequest;
import com.app.user.dto.CaseResponse;

public interface CaseService {
    CaseResponse acceptCase(AcceptCaseRequest request);
}