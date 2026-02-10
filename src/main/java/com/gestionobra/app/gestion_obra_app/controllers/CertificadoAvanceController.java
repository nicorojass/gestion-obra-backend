package com.gestionobra.app.gestion_obra_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionobra.app.gestion_obra_app.dtos.CertificadoAvanceDTO;
import com.gestionobra.app.gestion_obra_app.dtos.CertificadoMaterialDetalleDTO;
import com.gestionobra.app.gestion_obra_app.services.CertificadoAvanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/certificados-avance")
public class CertificadoAvanceController {
    
    @Autowired
    CertificadoAvanceService certificadoAvanceService;

    @PostMapping
    public ResponseEntity<CertificadoAvanceDTO> crearCertificado(@Valid @RequestBody CertificadoAvanceDTO certificado){
        CertificadoAvanceDTO certificadoCreado = certificadoAvanceService.crearCertificado(certificado);
        return ResponseEntity.status(HttpStatus.CREATED).body(certificadoCreado);
    }

    @GetMapping
    public ResponseEntity<List<CertificadoAvanceDTO>> traerCertificados(){
        return ResponseEntity.ok(certificadoAvanceService.traerCertificados());   
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificadoAvanceDTO> traerCertificado(@PathVariable Long id){
        return ResponseEntity.ok(certificadoAvanceService.traerCertificado(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CertificadoAvanceDTO> actualizarCertificado(@PathVariable Long id, @Valid @RequestBody CertificadoAvanceDTO certificado){
        return ResponseEntity.ok(certificadoAvanceService.actualizarCertificado(id, certificado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCertificado(@PathVariable Long id){
        certificadoAvanceService.eliminarCertificado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/materiales")
    public ResponseEntity<List<CertificadoMaterialDetalleDTO>> getMaterialesDelCertificado(
        @PathVariable Long id) {

    return ResponseEntity.ok(
            certificadoAvanceService.obtenerMaterialesDelCertificado(id)
        );
    }

}
