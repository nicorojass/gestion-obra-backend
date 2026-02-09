package com.gestionobra.app.gestion_obra_app.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionobra.app.gestion_obra_app.dtos.CertificadoAvanceDTO;
import com.gestionobra.app.gestion_obra_app.dtos.CertificadoMaterialDTO;
import com.gestionobra.app.gestion_obra_app.dtos.CertificadoMaterialDetalleDTO;
import com.gestionobra.app.gestion_obra_app.exceptions.NotFoundException;
import com.gestionobra.app.gestion_obra_app.mapper.Mapper;
import com.gestionobra.app.gestion_obra_app.models.CertificadoAvance;
import com.gestionobra.app.gestion_obra_app.models.CertificadoMaterial;
import com.gestionobra.app.gestion_obra_app.models.Material;
import com.gestionobra.app.gestion_obra_app.models.Obra;
import com.gestionobra.app.gestion_obra_app.repositories.CertificadoAvanceRepository;
import com.gestionobra.app.gestion_obra_app.repositories.CertificadoMaterialRepository;
import com.gestionobra.app.gestion_obra_app.repositories.MaterialRepository;
import com.gestionobra.app.gestion_obra_app.repositories.ObraRepository;

@Service
public class CertificadoAvanceService {
    
    @Autowired
    private CertificadoAvanceRepository certificadoRepository;
    
    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private MaterialRepository materialRepository;
    
    @Autowired
    private CertificadoMaterialRepository certificadoMaterialRepository;

    public CertificadoAvanceDTO crearCertificado(CertificadoAvanceDTO dto){

        // Comprobar si existe obra
        Obra obra = obraRepository.findById(dto.getObraId()).orElseThrow(() -> new NotFoundException("Obra no existente"));

        // Crear certificado con datos estaticos
        CertificadoAvance certificado = new CertificadoAvance();
        certificado.setFechaCreacion(LocalDateTime.now());
        certificado.setDescripcionTrabajo(dto.getDescripcionTrabajo());
        certificado.setPorcentajeAvance(dto.getPorcentajeAvance());
        certificado.setObra(obra);

        BigDecimal montoTotal = BigDecimal.ZERO;    
        List<CertificadoMaterial> relaciones = new ArrayList<>();

        // Procesar los materiales 
        for (CertificadoMaterialDTO mDto : dto.getMateriales()){
            
            Material material = materialRepository.findById(mDto.getMaterialId()).orElseThrow(() -> new NotFoundException("Material no encontrado"));
            Double cantidadUtilizada = mDto.getCantidadUtilizada();
 
            // Validar cantidad disponible con utilizada
            if (material.getCantidadAcopiada() < cantidadUtilizada){
                throw new IllegalStateException("La cantidad utilizada supera a la cantidad acopiada a la obra");
            }

            // Actualizar stock
            material.setCantidadConsumida(material.getCantidadConsumida() + cantidadUtilizada);
            material.setCantidadAcopiada(material.getCantidadAcopiada() - cantidadUtilizada);

            // Guardar material
            materialRepository.save(material);

            BigDecimal subTotal =
            material.getPrecioUnitario()
                .multiply(BigDecimal.valueOf(cantidadUtilizada));
            // Calcular costo
            subTotal = material.getPrecioUnitario().multiply(BigDecimal.valueOf(cantidadUtilizada));

            montoTotal = montoTotal.add(subTotal);

            CertificadoMaterial cm = new CertificadoMaterial();
            cm.setCertificado(certificado);
            cm.setMaterial(material);
            cm.setCantidadUtilizada(cantidadUtilizada);

            relaciones.add(cm);
        }

        certificado.setMontoCertificado(montoTotal);
        certificado.setMaterialesUtilizados(relaciones);

        certificado = certificadoRepository.save(certificado);

        return Mapper.toDto(certificado);
    }

    public List<CertificadoAvanceDTO> traerCertificados(){
        return certificadoRepository.findAll().stream().map(Mapper::toDto).toList();
    }

    public CertificadoAvanceDTO traerCertificado(Long id){
        return certificadoRepository.findById(id).map(Mapper::toDto).orElseThrow(() -> new NotFoundException("Certificado no encontrado"));
    }

    public CertificadoAvanceDTO actualizarCertificado(Long id, CertificadoAvanceDTO dto){
        CertificadoAvance certificado = certificadoRepository.findById(id).orElseThrow(() -> new NotFoundException("Certificado no encontrado"));
        return Mapper.toDto(certificadoRepository.save(certificado));
    }

    public void eliminarCertificado(Long id){
        if(!certificadoRepository.existsById(id)){
            throw new NotFoundException("Certificado no encontrado");
        }
        certificadoRepository.deleteById(id);
    }

    public List<CertificadoAvanceDTO> traerCertificadosPorObra(Long id){

        if (!obraRepository.existsById(id)){
            throw new NotFoundException("Obra no encontrada");
        }

        return certificadoRepository.findByObraId(id).stream().map(Mapper::toDto).toList();

    }

    public List<CertificadoMaterialDetalleDTO> obtenerMaterialesDelCertificado(Long certificadoId) {

    CertificadoAvance certificado =
            certificadoRepository.findByIdConMateriales(certificadoId)
                    .orElseThrow(() -> new NotFoundException("Certificado no encontrado"));

    return certificado.getMaterialesUtilizados()
            .stream()
            .map(Mapper::toDetalleDto)
            .toList();
}


}
