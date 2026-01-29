package com.gestionobra.app.gestion_obra_app.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@Table(name = "certificados")
public class CertificadoAvance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime fechaCreacion;
    private String descripcionTrabajo;
    private Integer porcentajeAvance;
    private BigDecimal montoCertificado;

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;

    @OneToMany(mappedBy = "certificado", cascade = CascadeType.ALL)
    private List<CertificadoMaterial> materialesUtilizados = new ArrayList<>();

}
