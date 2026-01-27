package com.gestionobra.app.gestion_obra_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionobra.app.gestion_obra_app.models.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    
}
