package com.gestionobra.app.gestion_obra_app.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.gestionobra.app.gestion_obra_app.models.enums.TipoMaterial;
import com.gestionobra.app.gestion_obra_app.models.enums.UnidadMedida;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "materiales")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoMaterial tipo;

    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;

    private Double cantidadEstimada;
    private Double cantidadAcopiada;
    private Double cantidadProveedor;
    private Double cantidadConsumida;

    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;

    @OneToMany(mappedBy = "material")
    private List<CertificadoMaterial> certificados = new ArrayList<>();
}
