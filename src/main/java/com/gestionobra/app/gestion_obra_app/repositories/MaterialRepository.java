package com.gestionobra.app.gestion_obra_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionobra.app.gestion_obra_app.models.Material;

public interface MaterialRepository extends JpaRepository<Material,Long> {
    List<Material> findByObraId(Long obraId);
}
