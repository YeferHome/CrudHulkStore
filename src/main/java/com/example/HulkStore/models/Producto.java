package com.example.HulkStore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private double precio;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private shoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "Usuario")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "usuario_producto",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    Set<Usuario> usuarios;
}

