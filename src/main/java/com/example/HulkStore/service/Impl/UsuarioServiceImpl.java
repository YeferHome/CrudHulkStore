package com.example.HulkStore.service.Impl;

import com.example.HulkStore.DTO.RequestUsuarioDTO;
import com.example.HulkStore.mapper.RequestMapperDto;
import com.example.HulkStore.models.Usuario;
import com.example.HulkStore.models.shoppingCart;
import com.example.HulkStore.repository.ShoppingCartRepository;
import com.example.HulkStore.repository.UsuarioRepository;
import com.example.HulkStore.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void crearusuario(RequestUsuarioDTO requestUsuarioDTO) {
        Usuario saveInformation = RequestMapperDto.dtoToRequestDto(requestUsuarioDTO);
        usuarioRepository.save(saveInformation);
    }

    @Override
    public Usuario findUsuarioById(Long Usuario_id) {
        return usuarioRepository.findById(Usuario_id).orElse(null);
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void updateUsuario(Long usuario_Id, Usuario updateUsuario) {
        Usuario nuevoUsuario = usuarioRepository.findById(usuario_Id).orElse(null);
        nuevoUsuario.setId(updateUsuario.getId());
        nuevoUsuario.setUsername(updateUsuario.getUsername());
        nuevoUsuario.setPassword(updateUsuario.getPassword());
        usuarioRepository.save(nuevoUsuario);
    }

    @Override
    public void deleteUsuario(Long usuario_Id) {
        usuarioRepository.deleteById(usuario_Id);
    }
}
