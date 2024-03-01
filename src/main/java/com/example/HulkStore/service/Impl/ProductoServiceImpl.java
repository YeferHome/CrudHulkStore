package com.example.HulkStore.service.Impl;

import com.example.HulkStore.models.Producto;
import com.example.HulkStore.models.Usuario;
import com.example.HulkStore.models.shoppingCart;
import com.example.HulkStore.repository.ProductoRepository;
import com.example.HulkStore.repository.UsuarioRepository;
import com.example.HulkStore.service.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements IProductoService {

    public final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, UsuarioRepository usuarioRepository) {
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void createproducto (Long usuarioId, Producto producto) {
        // Busca el usuario por su ID
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario != null) {
            // Obtiene el carrito de compras del usuario
            shoppingCart shoppingCart = usuario.getShoppingCart();
            // Asocia el producto al carrito de compras
            producto.setShoppingCart(shoppingCart);
            // Guarda el producto
            productoRepository.save(producto);
        }
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
