package com.example.HulkStore.service;

import com.example.HulkStore.DTO.RequestUsuarioDTO;
import com.example.HulkStore.models.Usuario;

import java.util.List;

public interface IUsuarioService  {

    void crearusuario(RequestUsuarioDTO requestUsuarioDTO);

    Usuario findUsuarioById(Long Usuario_id);

    List<Usuario> findAllUsuarios();

    void updateUsuario(Long usuario_Id, RequestUsuarioDTO updateUsuarioDTO);

    void deleteUsuario(Long usuario_Id);

}
