package com.example.HulkStore.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class shoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "shoppingCart")
    private List<Producto> productos;
    @ManyToOne
    private Usuario usuario;
}
