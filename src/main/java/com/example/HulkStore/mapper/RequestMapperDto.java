package com.example.HulkStore.mapper;

import com.example.HulkStore.DTO.RequestUsuarioDTO;
import com.example.HulkStore.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class RequestMapperDto {

    public static Usuario dtoToRequestDto(RequestUsuarioDTO requestUsuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setUsername(requestUsuarioDTO.getUsername());
        usuario.setPassword(requestUsuarioDTO.getPassword());
        return usuario;
    }

}
