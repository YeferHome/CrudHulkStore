package com.example.HulkStore.service.Impl;

import com.example.HulkStore.models.Producto;
import com.example.HulkStore.repository.ProductoRepository;
import com.example.HulkStore.repository.UsuarioRepository;
import com.example.HulkStore.service.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements IProductoService {

    public final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, UsuarioRepository usuarioRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void createproducto (Producto producto) {
            productoRepository.save(producto);
    }

    @Override
    public Producto findProductoById(Long producto_Id) {
        return productoRepository.findById(producto_Id).orElse(null);
    }

    @Override
    public List<Producto> findAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public void updateProducto(Long producto_Id, Producto updatedProducto) {
        Producto nuevoProducto = productoRepository.findById(producto_Id).orElse(null);
        nuevoProducto.setNombre(updatedProducto.getNombre());
        nuevoProducto.setPrecio(updatedProducto.getPrecio());
        nuevoProducto.setStock(updatedProducto.getStock());
        productoRepository.save(nuevoProducto);
    }

    @Override
    public void deleteProduct(Long producto_Id) {
        productoRepository.deleteById(producto_Id);
    }


}
