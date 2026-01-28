package com.gestionobra.app.gestion_obra_app.dtos;

import java.math.BigDecimal;

import com.gestionobra.app.gestion_obra_app.models.enums.TipoMaterial;
import com.gestionobra.app.gestion_obra_app.models.enums.UnidadMedida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

    private Long id;
    private String nombre;
    private TipoMaterial tipo;
    private UnidadMedida unidadMedida;
    
    private Double cantidadEstimada;
    private Double cantidadAcopiada;
    private Double cantidadProveedor;
    private Double cantidadConsumida;

    private BigDecimal precioUnitario;

    private Long obraId;
}

