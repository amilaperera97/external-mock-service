package com.external.mock.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String path;
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Item item;
}
