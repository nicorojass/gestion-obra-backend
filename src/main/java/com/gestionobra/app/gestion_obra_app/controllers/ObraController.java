package com.gestionobra.app.gestion_obra_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionobra.app.gestion_obra_app.dtos.ObraDTO;
import com.gestionobra.app.gestion_obra_app.services.ObraService;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @PostMapping
    public ResponseEntity<ObraDTO> crearObra(@RequestBody ObraDTO obra){
        obraService.crearObra(obra);
        return ResponseEntity.ok(obra);
    }
}
