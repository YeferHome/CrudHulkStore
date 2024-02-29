package com.example.HulkStore.service;

import com.example.HulkStore.models.Usuario;

import java.util.List;

public interface IUsuarioService {

    void crearusuario(Usuario usuario);

    Usuario findUsuarioById(Long Usuario_id);

    List<Usuario> findAllUsuarios();

    void updateUsuario(Long usuario_Id, Usuario updateProducto);

    void deleteUsuario(Long usuario_Id);

}
