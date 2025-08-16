package com.portfolio.controller;

import com.portfolio.model.OptimizarRequest;
import com.portfolio.model.Proyecto;
import com.portfolio.model.OptimizarResponse;
import com.portfolio.service.OptimizarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/optimizar")
public class OptimizarController {

    @Autowired
    private OptimizarService optimizarService;

    @PostMapping
    public ResponseEntity<?> optimizar(@RequestBody OptimizarRequest request) {
        if (request.getCapacidad() < 0) {
            return ResponseEntity.badRequest().body("La capacidad no puede ser negativa.");
        }
        if (request.getObjetos() == null || request.getObjetos().isEmpty()) {
            return ResponseEntity.badRequest().body("Debe ingresar al menos un proyecto.");
        }
        for (Proyecto obj : request.getObjetos()) {
            if (obj.getPeso() < 0 || obj.getGanancia() < 0) {
                return ResponseEntity.badRequest().body("Peso y ganancia deben ser positivos.");
            }
        }
        OptimizarResponse resp = optimizarService.optimizar(request);
        return ResponseEntity.ok(resp);
    }
}
