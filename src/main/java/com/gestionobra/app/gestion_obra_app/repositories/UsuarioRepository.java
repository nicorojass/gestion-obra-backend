package com.gestionobra.app.gestion_obra_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionobra.app.gestion_obra_app.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByEmail(String email);
}
