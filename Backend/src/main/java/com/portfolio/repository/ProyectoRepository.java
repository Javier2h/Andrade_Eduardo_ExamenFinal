package com.portfolio.repository;

import com.portfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    // Métodos personalizados si se requieren
}
