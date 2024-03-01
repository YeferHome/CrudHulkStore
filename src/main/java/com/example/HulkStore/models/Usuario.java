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

public class Usuario {

    //Declaracion de variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
/*
    //un usuario conectado con un carrito
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private shoppingCart shoppingCart;
*/

}
