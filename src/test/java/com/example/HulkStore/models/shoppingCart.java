package com.example.HulkStore.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import javax.annotation.processing.Generated;

@Entity
public class shoppingCart {
    @Id
    @Generated(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappeBy = "shoppingCart")
    private List<Producto> productos;
    @ManyToOne
    private Usuario usuario;
}
