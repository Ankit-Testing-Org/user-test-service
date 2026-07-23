package com.app.user.repository;

import com.app.user.entity.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<CaseEntity, Long> {
}