package com.example.HulkStore.controllers;

import com.example.HulkStore.models.Producto;
import com.example.HulkStore.repository.ProductoRepository;
import com.example.HulkStore.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class controllers {
    @Autowired
    private ProductoRepository productoRepository;
    private IProductoService productoService;

    @GetMapping()
    public String index(){
        return "¡¡¡CONEXION EXITOSA!!!";
    }

    @PostMapping("/productos")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Producto no encontrado con id: " + id));
        return ResponseEntity.ok().body(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id,
                                                       @RequestBody Producto productoActualizado) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Producto no encontrado con id: " + id));

        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setStock(productoActualizado.getStock());

        final Producto productoActualizadoGuardado = productoRepository.save(producto);
        return ResponseEntity.ok(productoActualizadoGuardado);
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.deleteProduct(id);
    }
}

