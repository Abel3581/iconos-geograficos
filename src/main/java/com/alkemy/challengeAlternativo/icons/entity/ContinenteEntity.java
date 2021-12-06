package com.alkemy.challengeAlternativo.icons.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "continente")
@Getter
@Setter
@SQLDelete(sql = "UPDATE continente SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")

public class ContinenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String imagen;
    private String denominacion;
    private boolean deleted = Boolean.FALSE;
}
