package com.gestionobra.app.gestion_obra_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionobra.app.gestion_obra_app.dtos.UsuarioDTO;
import com.gestionobra.app.gestion_obra_app.exceptions.NotFoundException;
import com.gestionobra.app.gestion_obra_app.mapper.Mapper;
import com.gestionobra.app.gestion_obra_app.models.Usuario;
import com.gestionobra.app.gestion_obra_app.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO crearUsuario(UsuarioDTO u){
        Usuario usuarioGuardado = new Usuario();

        usuarioGuardado.setNombre(u.getNombre());
        usuarioGuardado.setEmail(u.getEmail());
        usuarioGuardado.setPassword(u.getPassword());
        usuarioGuardado.setRol(u.getRol());

        usuarioGuardado = usuarioRepository.save(usuarioGuardado);

        return Mapper.toDto(usuarioGuardado);  
     }

     public List<UsuarioDTO> traerUsuarios(){
         return usuarioRepository.findAll().stream().map(Mapper::toDto).toList();
     }

     public UsuarioDTO traerUsuario(Long id){
         return usuarioRepository.findById(id).map(Mapper::toDto).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
     }

     public void eliminarUsuario(Long id){
         if (!usuarioRepository.existsById(id)){
             throw new NotFoundException("Usuario no encontrado");
         }

         usuarioRepository.deleteById(id);
     }

     public void actualizarUsuario(Long id, UsuarioDTO u){
         Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

         usuario.setNombre(u.getNombre());
         usuario.setEmail(u.getEmail());
         usuario.setPassword(u.getPassword());
         usuario.setRol(u.getRol());

         usuarioRepository.save(usuario);
     }

}
