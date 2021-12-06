package com.alkemy.challengeAlternativo.icons.repository.specifications;

import com.alkemy.challengeAlternativo.icons.dto.PaisFiltersDTO;
import com.alkemy.challengeAlternativo.icons.entity.ContinenteEntity;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PaisSpecification {
    public Specification<PaisEntity> getByFilters(PaisFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denominacion")),
                                "%" + filtersDTO.getName().toLowerCase() + "%")
                );
            }
            if (!ObjectUtils.isEmpty(filtersDTO.getContinenteId())) {
                Long continenteId = filtersDTO.getContinenteId();
                predicates.add(
                        criteriaBuilder.equal(root.get("continenteId"), continenteId)
                );
            }

            //Remove duplicates
            query.distinct(true);

            //orden
            String orderByField = "denominacion";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
