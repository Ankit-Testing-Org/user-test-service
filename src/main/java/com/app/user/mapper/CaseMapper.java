package com.app.user.mapper;

import com.app.user.dto.AcceptCaseRequest;
import com.app.user.dto.CaseResponse;
import com.app.user.entity.CaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CaseMapper {
    @Mapping(target = "id", source = "caseId")
    CaseEntity toEntity(AcceptCaseRequest request);

    CaseResponse toDto(CaseEntity entity);
}