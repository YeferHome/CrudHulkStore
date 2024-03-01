package com.example.HulkStore.service.Impl;

import com.example.HulkStore.DTO.RequestUsuarioDTO;
import com.example.HulkStore.mapper.RequestMapperDto;
import com.example.HulkStore.models.Usuario;
import com.example.HulkStore.repository.UsuarioRepository;
import com.example.HulkStore.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RequestMapperDto requestMapperDto;

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
    public void updateUsuario(Long usuario_Id, RequestUsuarioDTO updateUsuarioDTO) {
        Usuario usuario = usuarioRepository.findById(usuario_Id).orElse(null);
            Usuario usuarioActualizado = requestMapperDto.dtoToRequestDto(updateUsuarioDTO);
            usuario.setUsername(usuarioActualizado.getUsername());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuarioRepository.save(usuario);

    }
    @Override
    public void deleteUsuario(Long usuario_Id) {
        usuarioRepository.deleteById(usuario_Id);
    }
}
