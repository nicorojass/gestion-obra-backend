package com.gestionobra.app.gestion_obra_app.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObraDTO {

    private Long id;

    @NotBlank(message = "El nombre de la obra es obligatorio")
    @Size(min = 3, max = 80, message = "El nombre debe tener entre 3 y 80 caracteres")
    private String nombre;

    @NotBlank(message = "La ubicación es obligatoria")
    @Size(min = 5, max = 120, message = "La ubicación debe tener entre 5 y 120 caracteres")
    private String ubicacion;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 300, message = "La descripción debe tener entre 10 y 300 caracteres")
    private String descripcion;

}
