package com.external.mock.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String unitWeight;
    private String measurementType;
}
