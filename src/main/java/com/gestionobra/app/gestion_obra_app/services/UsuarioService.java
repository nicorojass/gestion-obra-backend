package com.gestionobra.app.gestion_obra_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionobra.app.gestion_obra_app.dtos.UsuarioDTO;
import com.gestionobra.app.gestion_obra_app.models.Usuario;
import com.gestionobra.app.gestion_obra_app.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

}
