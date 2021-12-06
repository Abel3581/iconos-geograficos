package com.alkemy.challengeAlternativo.icons.repository;

import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IconRepository extends JpaRepository<IconEntity, Long>, JpaSpecificationExecutor<IconEntity> {

    List<IconEntity> findAll(Specification<IconEntity> spec);
}
