package com.gestionobra.app.gestion_obra_app.mapper;

import com.gestionobra.app.gestion_obra_app.dtos.MaterialDTO;
import com.gestionobra.app.gestion_obra_app.dtos.ObraDTO;
import com.gestionobra.app.gestion_obra_app.models.Material;
import com.gestionobra.app.gestion_obra_app.models.Obra;

public class Mapper {

    // Obra a ObraDTO
    public static ObraDTO toDto(Obra o){
        if (o == null) return null;

        ObraDTO dto = new ObraDTO();

        dto.setId(o.getId());
        dto.setNombre(o.getNombre());
        dto.setDescripcion(o.getDescripcion());
        dto.setUbicacion(o.getUbicacion());

        return dto;
    } 

    public static MaterialDTO toDto(Material m){
        if (m == null) return null;

        MaterialDTO dto = new MaterialDTO();

        dto.setId(m.getId());
        dto.setNombre(m.getNombre());
        dto.setTipo(m.getTipo());
        dto.setUnidadMedida(m.getUnidadMedida());
        dto.setCantidadEstimada(m.getCantidadEstimada());
        dto.setCantidadAcopiada(m.getCantidadAcopiada());
        dto.setCantidadProveedor(m.getCantidadProveedor());
        dto.setCantidadConsumida(m.getCantidadConsumida());
        dto.setPrecioUnitario(m.getPrecioUnitario());
        dto.setObraId(m.getObra().getId());

        return dto;
    }

    




    
}
