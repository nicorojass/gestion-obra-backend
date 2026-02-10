package com.gestionobra.app.gestion_obra_app.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "La descripción del trabajo es obligatoria")
    @Size(min = 10, max = 250, message = "La descripción debe tener entre 10 y 250 caracteres")
    private String descripcionTrabajo;

    @NotNull(message = "El porcentaje de avance es obligatorio")
    @Min(value = 1, message = "El avance mínimo es 1%")
    @Max(value = 100, message = "El avance máximo es 100%")
    private Integer porcentajeAvance;

    private BigDecimal montoTotal;

    @NotNull(message = "Debe indicar a qué obra pertenece el certificado")
    private Long obraId;

    @NotEmpty(message = "Debe cargar al menos un material utilizado")
    @Valid
    private List<CertificadoMaterialDTO> materiales;
}

