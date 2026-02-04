package com.gestionobra.app.gestion_obra_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionobra.app.gestion_obra_app.dtos.MaterialDTO;
import com.gestionobra.app.gestion_obra_app.exceptions.NotFoundException;
import com.gestionobra.app.gestion_obra_app.mapper.Mapper;
import com.gestionobra.app.gestion_obra_app.models.Material;
import com.gestionobra.app.gestion_obra_app.models.Obra;
import com.gestionobra.app.gestion_obra_app.repositories.CertificadoAvanceRepository;
import com.gestionobra.app.gestion_obra_app.repositories.CertificadoMaterialRepository;
import com.gestionobra.app.gestion_obra_app.repositories.MaterialRepository;
import com.gestionobra.app.gestion_obra_app.repositories.ObraRepository;

@Service
public class MaterialService {
    
    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private CertificadoAvanceRepository certificadoRepository;

    @Autowired
    private CertificadoMaterialRepository cMRepository;


    public MaterialDTO crearMaterial(MaterialDTO material){
        Material materialGuardado = new Material();

        materialGuardado.setNombre(material.getNombre());
        materialGuardado.setTipo(material.getTipo());
        materialGuardado.setUnidadMedida(material.getUnidadMedida());
        materialGuardado.setCantidadEstimada(material.getCantidadEstimada());
        materialGuardado.setCantidadAcopiada(material.getCantidadAcopiada());
        materialGuardado.setCantidadProveedor(material.getCantidadProveedor());
        materialGuardado.setCantidadConsumida(material.getCantidadConsumida());
        materialGuardado.setPrecioUnitario(material.getPrecioUnitario());
        
        Obra obra = obraRepository.findById(material.getObraId()).orElseThrow(() -> new NotFoundException("Obra no encontrada"));
        materialGuardado.setObra(obra);

        return Mapper.toDto(materialRepository.save(materialGuardado));
    }

    public List<MaterialDTO> traerMateriales(){
        return materialRepository.findAll().stream().map(Mapper::toDto).toList();
    }

    public MaterialDTO traerMaterialPorId(Long id){
        return materialRepository.findById(id).map(Mapper::toDto).orElseThrow(() -> new NotFoundException("Material no encontrado"));
    }

    public MaterialDTO actualizarMaterial(Long id, MaterialDTO material){
        Material materialGuardado = materialRepository.findById(id).orElseThrow(() -> new NotFoundException("Material no encontrado"));

        materialGuardado.setNombre(material.getNombre());
        materialGuardado.setTipo(material.getTipo());
        materialGuardado.setUnidadMedida(material.getUnidadMedida());
        materialGuardado.setCantidadEstimada(material.getCantidadEstimada());
        materialGuardado.setCantidadAcopiada(material.getCantidadAcopiada());
        materialGuardado.setCantidadProveedor(material.getCantidadProveedor());
        materialGuardado.setCantidadConsumida(material.getCantidadConsumida());
        materialGuardado.setPrecioUnitario(material.getPrecioUnitario());
        
        Obra obra = obraRepository.findById(material.getObraId()).orElseThrow(() -> new NotFoundException("Obra no encontrada"));
        materialGuardado.setObra(obra);

        return Mapper.toDto(materialRepository.save(materialGuardado));
    }

    public void eliminarMaterial(Long id){
        if (!materialRepository.existsById(id)){
            throw new NotFoundException("Material no encontrado");
        }

        materialRepository.deleteById(id);
    }

    public List<MaterialDTO> traerMaterialesPorObra(Long id){

        if (!obraRepository.existsById(id)){
            throw new NotFoundException("Obra no encontrada");
        }

        return materialRepository.findByObraId(id).stream().map(Mapper::toDto).toList();

    }
    
}
