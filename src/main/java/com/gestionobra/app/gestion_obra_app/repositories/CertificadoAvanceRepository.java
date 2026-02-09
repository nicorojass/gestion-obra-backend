package com.gestionobra.app.gestion_obra_app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestionobra.app.gestion_obra_app.models.CertificadoAvance;

public interface CertificadoAvanceRepository extends JpaRepository<CertificadoAvance, Long> {
    List<CertificadoAvance> findByObraId(Long id);

    @Query("""
    SELECT c FROM CertificadoAvance c
    LEFT JOIN FETCH c.materialesUtilizados cm
    LEFT JOIN FETCH cm.material
    WHERE c.id = :id
    """)
    Optional<CertificadoAvance> findByIdConMateriales(Long id);
}
