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
    @JoinColumn(name = "item_id", nullable = false, insertable = false, updatable = false,referencedColumnName = "id")
    private Item item;
}
