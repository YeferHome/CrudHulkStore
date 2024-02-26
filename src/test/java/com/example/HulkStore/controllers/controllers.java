package com.example.HulkStore.controllers;

import com.example.HulkStore.models.Producto;
import com.example.HulkStore.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
public class controllers {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping()
    public String index(){
        return "¡¡¡CONEXCION EXITOSA!!!";
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
    public Map<String, Boolean> eliminarProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Producto no encontrado con id: " + id));
        productoRepository.delete(producto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return respuesta;
    }
}

