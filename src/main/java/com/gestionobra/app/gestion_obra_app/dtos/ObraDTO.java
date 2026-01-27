package com.gestionobra.app.gestion_obra_app.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObraDTO {
    private Long id;
    private String nombre;
    private String ubicacion;
    private String descripcion;

    private List<Long> materialesIds;
    private List<Long> certificadosIds;
}
