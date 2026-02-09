package com.gestionobra.app.gestion_obra_app.mapper;

import java.math.BigDecimal;

import com.gestionobra.app.gestion_obra_app.dtos.CertificadoAvanceDTO;
import com.gestionobra.app.gestion_obra_app.dtos.CertificadoMaterialDTO;
import com.gestionobra.app.gestion_obra_app.dtos.CertificadoMaterialDetalleDTO;
import com.gestionobra.app.gestion_obra_app.dtos.MaterialDTO;
import com.gestionobra.app.gestion_obra_app.dtos.ObraDTO;
import com.gestionobra.app.gestion_obra_app.models.CertificadoAvance;
import com.gestionobra.app.gestion_obra_app.models.CertificadoMaterial;
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

    // Material a MaterialDTO
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

    // CertificadoAvance a CertificadoAvanceDTO
    public static CertificadoAvanceDTO toDto(CertificadoAvance c){
        if (c == null) return null;

        CertificadoAvanceDTO dto = new CertificadoAvanceDTO();

        dto.setId(c.getId());
        dto.setFechaCreacion(c.getFechaCreacion());
        dto.setDescripcionTrabajo(c.getDescripcionTrabajo());
        dto.setMontoTotal(c.getMontoCertificado());
        dto.setPorcentajeAvance(c.getPorcentajeAvance());
        dto.setObraId(c.getObra().getId());

        if (c.getMaterialesUtilizados() != null) {
        dto.setMateriales(
            c.getMaterialesUtilizados()
             .stream()
             .map(Mapper::toDto)
             .toList()
            );
        }

        return dto;
    }

    // CertificadoMaterial a CertificadoMaterialDTO
    public static CertificadoMaterialDTO toDto(CertificadoMaterial cm) {
    if (cm == null) return null;

    CertificadoMaterialDTO dto = new CertificadoMaterialDTO();
    dto.setMaterialId(cm.getMaterial().getId());
    dto.setCantidadUtilizada(cm.getCantidadUtilizada());

    return dto;
}

    public static CertificadoMaterialDetalleDTO toDetalleDto(CertificadoMaterial cm) {

    CertificadoMaterialDetalleDTO dto = new CertificadoMaterialDetalleDTO();

    dto.setMaterialId(cm.getMaterial().getId());
    dto.setNombreMaterial(cm.getMaterial().getNombre());
    dto.setCantidadUtilizada(cm.getCantidadUtilizada());

    dto.setPrecioUnitario(cm.getMaterial().getPrecioUnitario());

    BigDecimal subtotal =
        cm.getMaterial().getPrecioUnitario()
          .multiply(BigDecimal.valueOf(cm.getCantidadUtilizada()));

    dto.setSubtotal(subtotal);

    return dto;
}
    
}
