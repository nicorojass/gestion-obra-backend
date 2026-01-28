package com.gestionobra.app.gestion_obra_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionobra.app.gestion_obra_app.dtos.MaterialDTO;
import com.gestionobra.app.gestion_obra_app.dtos.ObraDTO;
import com.gestionobra.app.gestion_obra_app.exceptions.NotFoundException;
import com.gestionobra.app.gestion_obra_app.mapper.Mapper;
import com.gestionobra.app.gestion_obra_app.models.Material;
import com.gestionobra.app.gestion_obra_app.models.Obra;
import com.gestionobra.app.gestion_obra_app.repositories.MaterialRepository;
import com.gestionobra.app.gestion_obra_app.repositories.ObraRepository;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;


    public ObraDTO crearObra(ObraDTO o){
        Obra obraGuardada = new Obra();

        obraGuardada.setNombre(o.getNombre());
        obraGuardada.setDescripcion(o.getDescripcion());
        obraGuardada.setUbicacion(o.getUbicacion());

        return Mapper.toDto(obraRepository.save(obraGuardada));
    }

    public List<ObraDTO> traerObras(){
        return obraRepository.findAll().stream().map(Mapper::toDto).toList();
    }

    public ObraDTO traerObraPorId(Long id){
        return obraRepository.findById(id).map(Mapper::toDto).orElseThrow(() -> new NotFoundException("Obra no encontrada"));
    }

    public ObraDTO actualizarObra(Long id, ObraDTO o){
        
        Obra obra = obraRepository.findById(id).orElseThrow(() -> new NotFoundException("Obra no encontrada"));

        obra.setNombre(o.getNombre());
        obra.setDescripcion(o.getDescripcion());
        obra.setUbicacion(o.getUbicacion());
        
        Obra obraPersistida = obraRepository.save(obra);

        return Mapper.toDto(obraPersistida);
    }

    public void eliminarObra(long id){
        if (!obraRepository.existsById(id)){
            throw new NotFoundException("Obra no encontrada");
        }

        obraRepository.deleteById(id);
    }

}
