package com.example.HulkStore.controllers;

import com.example.HulkStore.DTO.RequestUsuarioDTO;
import com.example.HulkStore.models.Usuario;
import com.example.HulkStore.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioControllers {
    @Autowired
    private IUsuarioService UsuarioServicio;

    @GetMapping("/usuarios")
    public List<Usuario> findAllUsuarios() {
        return UsuarioServicio.findAllUsuarios();
    }

    @GetMapping("/usuarios/{usuario_Id}")
    public Usuario findUsuarioById(@PathVariable Long usuario_Id) {
        return UsuarioServicio.findUsuarioById(usuario_Id);
    }

    @PostMapping("/crearusuario")
    public void crearusuario(@RequestBody RequestUsuarioDTO requestUsuarioDTO){
        UsuarioServicio.crearusuario(requestUsuarioDTO);
    }
    @PutMapping("/editarusuario/{usuario_Id}")
    public void updateUsuario(@PathVariable Long usuario_Id, @RequestBody RequestUsuarioDTO usuarioDTO){
        UsuarioServicio.updateUsuario(usuario_Id, usuarioDTO);
    }

    @DeleteMapping("/delete/{Usuario_Id}")
    public void deleteUsuario(@PathVariable Long Usuario_Id ){
        UsuarioServicio.deleteUsuario(Usuario_Id);
    }
}
