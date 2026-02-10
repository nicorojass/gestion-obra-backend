package com.gestionobra.app.gestion_obra_app.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionobra.app.gestion_obra_app.dtos.MaterialDTO;
import com.gestionobra.app.gestion_obra_app.services.MaterialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping
    public ResponseEntity<MaterialDTO> crearMaterial(@Valid @RequestBody MaterialDTO material){
        MaterialDTO materialCreado = materialService.crearMaterial(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(materialCreado);
    }

    @GetMapping 
    public ResponseEntity<List<MaterialDTO>> traerMateriales(){
        return ResponseEntity.ok(materialService.traerMateriales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> traerMaterialPorId(@PathVariable Long id){
        return ResponseEntity.ok(materialService.traerMaterialPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDTO> actualizarMaterial(@PathVariable Long id, @Valid @RequestBody MaterialDTO material){
        return ResponseEntity.ok(materialService.actualizarMaterial(id, material));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMaterial(@PathVariable Long id){
        materialService.eliminarMaterial(id);
        return ResponseEntity.noContent().build();
    }

}
