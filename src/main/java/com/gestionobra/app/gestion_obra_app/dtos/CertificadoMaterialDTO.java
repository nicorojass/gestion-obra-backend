package com.gestionobra.app.gestion_obra_app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoMaterialDTO {
    private Long materialId;
    private Double cantidadUtilizada;
}
