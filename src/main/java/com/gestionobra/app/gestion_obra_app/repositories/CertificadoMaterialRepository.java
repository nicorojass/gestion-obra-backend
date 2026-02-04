package com.gestionobra.app.gestion_obra_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionobra.app.gestion_obra_app.dtos.CertificadoMaterialDTO;
import com.gestionobra.app.gestion_obra_app.models.CertificadoMaterial;

public interface CertificadoMaterialRepository extends JpaRepository<CertificadoMaterial, Long> {
    
}
