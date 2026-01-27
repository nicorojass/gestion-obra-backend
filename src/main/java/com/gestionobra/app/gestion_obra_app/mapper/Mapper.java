package com.gestionobra.app.gestion_obra_app.mapper;

import com.gestionobra.app.gestion_obra_app.dtos.ObraDTO;
import com.gestionobra.app.gestion_obra_app.models.Obra;

public class Mapper {

    // Obra a ObraDTO
    public static ObraDTO toDto(Obra o){
        if (o == null) return null;

        ObraDTO dto = new ObraDTO();

        dto.setNombre(o.getNombre());
        dto.setDescripcion(o.getDescripcion());
        dto.setUbicacion(o.getUbicacion());

        return dto;
    } 







    
}
