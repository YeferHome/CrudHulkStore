package com.example.HulkStore.controllers;

import com.example.HulkStore.models.Producto;
import com.example.HulkStore.service.IProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoControllers {

    private IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> findAllProducto() {
        return productoService.findAllProducto();
    }

    @GetMapping("/productos/{producto_Id}")
    public Producto findProductoById(@PathVariable Long producto_Id) {
        return productoService.findProductoById(producto_Id);
    }

    @PostMapping("/crearproducto")
    public void createproducto(@RequestBody Producto producto) {
        productoService.createproducto(producto);
    }

    @PutMapping("/editar/{producto_Id}")
    public void updateProducto(@PathVariable Long producto_Id, @RequestBody Producto producto) {
        productoService.updateProducto(producto_Id, producto);
    }


    @DeleteMapping("/delete/{producto_Id}")
    public void deleteProducto(@PathVariable Long producto_Id) {

        productoService.deleteProduct(producto_Id);
    }


}
