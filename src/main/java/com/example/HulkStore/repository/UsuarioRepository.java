package com.example.HulkStore.repository;

import com.example.HulkStore.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario,Long> {

}
