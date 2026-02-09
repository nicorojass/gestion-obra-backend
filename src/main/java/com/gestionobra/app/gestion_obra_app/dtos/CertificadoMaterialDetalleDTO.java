package com.gestionobra.app.gestion_obra_app.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoMaterialDetalleDTO {
    private Long materialId;
    private String nombreMaterial;
    private Double cantidadUtilizada;

    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
