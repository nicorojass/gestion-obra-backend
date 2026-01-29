package com.gestionobra.app.gestion_obra_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionobra.app.gestion_obra_app.dtos.CertificadoAvanceDTO;
import com.gestionobra.app.gestion_obra_app.exceptions.NotFoundException;
import com.gestionobra.app.gestion_obra_app.mapper.Mapper;
import com.gestionobra.app.gestion_obra_app.models.CertificadoAvance;
import com.gestionobra.app.gestion_obra_app.models.Obra;
import com.gestionobra.app.gestion_obra_app.repositories.CertificadoAvanceRepository;
import com.gestionobra.app.gestion_obra_app.repositories.ObraRepository;

@Service
public class CertificadoAvanceService {
    
    @Autowired
    private CertificadoAvanceRepository certificadoRepository;

    @Autowired
    private ObraRepository obraRepository;

    

}
