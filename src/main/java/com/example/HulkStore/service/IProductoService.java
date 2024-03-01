package com.example.HulkStore.service;

import com.example.HulkStore.models.Producto;

import java.util.List;

public interface IProductoService {

    void createproducto(Long usuarioId, Producto producto);

    Producto findProductoById(Long producto_Id);

    List<Producto> findAllProducto();

    void updateProducto(Long producto_Id, Producto updatedProducto);

    void deleteProduct(Long producto_Id);


}

