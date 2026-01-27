package com.gestionobra.app.gestion_obra_app.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoAvanceDTO {

    private Long id;
    private LocalDateTime fechaCreacion;

    private String descripcionTrabajo;

    private BigDecimal montoTotal;
    private Integer porcentajeAvance;

    private Long obraId;

    private List<CertificadoMaterialDTO> materiales;
}

