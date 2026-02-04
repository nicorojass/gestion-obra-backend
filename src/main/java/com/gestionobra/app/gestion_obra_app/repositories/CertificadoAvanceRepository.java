package com.gestionobra.app.gestion_obra_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionobra.app.gestion_obra_app.models.CertificadoAvance;

public interface CertificadoAvanceRepository extends JpaRepository<CertificadoAvance, Long> {
    List<CertificadoAvance> findByObraId(Long id);
}
