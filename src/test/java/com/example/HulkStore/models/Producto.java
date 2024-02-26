package com.example.HulkStore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private  Long id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private double precio;
    @Getter
    @Setter
    private int stock;
}

