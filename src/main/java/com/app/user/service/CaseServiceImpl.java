package com.app.user.service;

import com.app.user.dto.AcceptCaseRequest;
import com.app.user.dto.CaseResponse;
import com.app.user.entity.CaseEntity;
import com.app.user.mapper.CaseMapper;
import com.app.user.repository.CaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaseServiceImpl implements CaseService {
    private final CaseRepository caseRepository;
    private final CaseMapper caseMapper;

    public CaseServiceImpl(CaseRepository caseRepository, CaseMapper caseMapper) {
        this.caseRepository = caseRepository;
        this.caseMapper = caseMapper;
    }

    @Override
    @Transactional
    public CaseResponse acceptCase(AcceptCaseRequest request) {
        CaseEntity caseEntity = caseMapper.toEntity(request);
        caseEntity.setStatus(Status.ACCEPTED);
        this.caseRepository.save(caseEntity);
        return caseMapper.toDto(caseEntity);
    }
}