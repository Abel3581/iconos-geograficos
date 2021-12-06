package com.alkemy.challengeAlternativo.icons.repository;

import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PaisRepository extends JpaRepository<PaisEntity, Long>, JpaSpecificationExecutor<PaisEntity> {

    List<PaisEntity> findAll(Specification<PaisEntity> spec);
}
