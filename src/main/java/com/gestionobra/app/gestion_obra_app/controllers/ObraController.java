package com.gestionobra.app.gestion_obra_app.controllers;

import java.util.List;

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
import com.gestionobra.app.gestion_obra_app.dtos.ObraDTO;
import com.gestionobra.app.gestion_obra_app.services.MaterialService;
import com.gestionobra.app.gestion_obra_app.services.ObraService;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ObraService obraService;

    @PostMapping
    public ResponseEntity<ObraDTO> crearObra(@RequestBody ObraDTO obra){
        ObraDTO obraCreada = obraService.crearObra(obra);
        return ResponseEntity.status(HttpStatus.CREATED).body(obraCreada);
    }

    @GetMapping
    public ResponseEntity<List<ObraDTO>> traerObras(){
        return ResponseEntity.ok(obraService.traerObras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraDTO> traerObraPorId(@PathVariable Long id){
        return ResponseEntity.ok(obraService.traerObraPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraDTO> actualizarObra(@PathVariable Long id, @RequestBody ObraDTO obra){
        ObraDTO obraActualizada = obraService.actualizarObra(id, obra);
        return ResponseEntity.ok(obraActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarObra (@PathVariable Long id){
        obraService.eliminarObra(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/materiales")
    public ResponseEntity<List<MaterialDTO>> traerMaterialesPorObraId(@PathVariable Long id){
        return ResponseEntity.ok(materialService.traerMaterialesPorObra(id));
    }

}
