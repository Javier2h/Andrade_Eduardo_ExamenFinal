package com.portfolio.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resultados")
public class ResultadosHistoricos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String proyectos_seleccionados;

    private int ganancia_total;
    private int peso_total;
    private LocalDateTime fecha;

    public ResultadosHistoricos() {}

    public ResultadosHistoricos(String proyectos_seleccionados, int ganancia_total, int peso_total, LocalDateTime fecha) {
        this.proyectos_seleccionados = proyectos_seleccionados;
        this.ganancia_total = ganancia_total;
        this.peso_total = peso_total;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public String getProyectos_seleccionados() { return proyectos_seleccionados; }
    public void setProyectos_seleccionados(String proyectos_seleccionados) { this.proyectos_seleccionados = proyectos_seleccionados; }
    public int getGanancia_total() { return ganancia_total; }
    public void setGanancia_total(int ganancia_total) { this.ganancia_total = ganancia_total; }
    public int getPeso_total() { return peso_total; }
    public void setPeso_total(int peso_total) { this.peso_total = peso_total; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
