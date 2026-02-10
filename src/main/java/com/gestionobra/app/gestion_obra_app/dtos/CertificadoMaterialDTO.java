package com.gestionobra.app.gestion_obra_app.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoMaterialDTO {
    
    @NotNull(message = "Debe indicar el material")
    private Long materialId;

    @NotNull(message = "Debe indicar la cantidad utilizada")
    @Positive(message = "La cantidad utilizada debe ser mayor a 0")
    private Double cantidadUtilizada;
}
