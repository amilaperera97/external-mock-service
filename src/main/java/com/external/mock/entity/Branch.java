package com.external.mock.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "branch")
@Data
public class Branch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    private Shop shopId;
    @Column(name = "address")
    private String address;
}
