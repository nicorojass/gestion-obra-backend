package com.gestionobra.app.gestion_obra_app.dtos;

import java.math.BigDecimal;

import com.gestionobra.app.gestion_obra_app.models.enums.TipoMaterial;
import com.gestionobra.app.gestion_obra_app.models.enums.UnidadMedida;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

    private Long id;
    @NotBlank(message = "El nombre del material es obligatorio")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;

    @NotNull(message = "El tipo de material es obligatorio")
    private TipoMaterial tipo;

    @NotNull(message = "La unidad de medida es obligatoria")
    private UnidadMedida unidadMedida;

    @NotNull(message = "La cantidad estimada es obligatoria")
    @Positive(message = "La cantidad estimada debe ser mayor a 0")
    private Double cantidadEstimada;

    @PositiveOrZero(message = "La cantidad acopiada no puede ser negativa")
    private Double cantidadAcopiada = 0.0;

    @PositiveOrZero(message = "La cantidad en proveedor no puede ser negativa")
    private Double cantidadProveedor = 0.0;

    @PositiveOrZero(message = "La cantidad consumida no puede ser negativa")
    private Double cantidadConsumida = 0.0;

    @NotNull(message = "El precio unitario es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    private BigDecimal precioUnitario;

    @NotNull(message = "El material debe pertenecer a una obra")
    private Long obraId;

}

