package com.example.HulkStore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nombre;

    private double precio;

    private int stock;

    @ManyToOne
    @JoinColumn(name= "shopping_cart_id")
    private shoppingCart shoppingCart;

}
